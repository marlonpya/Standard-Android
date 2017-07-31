package pya.marlon.com.friends.data.db.manager;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import pya.marlon.com.friends.data.db.model.UserSql;

/**
 * Created by marlonpya on 23/07/17.
 */

public class UserManagerSql implements ManagerSql<UserSql> {
    private static final String TAG = "UserManagerSql";

    @Override
    public String primaryKey() {
        return UserSql.primaryKey;
    }

    @Override
    public int lastId() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(UserSql.class).max(this.primaryKey());
        int id = number == null ? 1 : number.intValue() + 1;
        realm.close();
        return id;
    }

    @Override
    public void createOrUpdate(UserSql object) {
        Log.d(TAG, "createOrUpdate: " + object.toString());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(object);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void createOrUpdate(List<UserSql> list) {
        Realm realm = Realm.getDefaultInstance();
        for (UserSql userSql: list) {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(userSql);
            realm.commitTransaction();
        }
        realm.close();
    }

    @Override
    public UserSql getById(int id) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UserSql.class).equalTo(this.primaryKey(), id).findFirst();
    }

    @Override
    public List<UserSql> getListByKey(String key, Object value) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UserSql.class).equalTo(key, (String) value).findAll();
    }

    @Override
    public void deleteById(int id) {
        Realm realm = Realm.getDefaultInstance();
        UserSql userSql = realm.where(UserSql.class).equalTo(this.primaryKey(), id).findFirst();
        realm.beginTransaction();
        userSql.deleteFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void delete() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(UserSql.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    public List<UserSql> getList() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UserSql.class).findAll();
    }
}
