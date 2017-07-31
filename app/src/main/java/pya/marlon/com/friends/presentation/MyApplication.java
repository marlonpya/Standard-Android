package pya.marlon.com.friends.presentation;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import pya.marlon.com.friends.data.db.MyRealmModule;
import pya.marlon.com.friends.data.rest.RetrofitService;
import pya.marlon.com.friends.util.constant.Constant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marlonpya on 23/07/17.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
        Realm.setDefaultConfiguration(getRealmConfiguration());
    }

    private RealmConfiguration getRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .modules(new MyRealmModule())
                .name(Constant.SQLite.NAME)
                .schemaVersion(Constant.SQLite.VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    public RetrofitService getService() {
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.Connection.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getRequestHeader())
                    .build();
        }

        return retrofit.create(RetrofitService.class);
    }

    private OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.newBuilder().readTimeout(Constant.Connection.TIME_OUT, TimeUnit.SECONDS);
        httpClient.newBuilder().connectTimeout(Constant.Connection.TIME_OUT, TimeUnit.SECONDS);
        return httpClient;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
