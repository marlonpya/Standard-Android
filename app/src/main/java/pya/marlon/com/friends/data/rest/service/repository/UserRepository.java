package pya.marlon.com.friends.data.rest.service.repository;

import pya.marlon.com.friends.data.rest.response.UserListResponse;
import pya.marlon.com.friends.data.rest.service.RxObserver;
import pya.marlon.com.friends.data.rest.service.UserService;
import pya.marlon.com.friends.domain.dto.ServiceResponse;
import pya.marlon.com.friends.presentation.MyApplication;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by marlonpya on 23/07/17.
 */

public class UserRepository implements UserService {
    @Override
    public Subscription getFriends(ServiceResponse<UserListResponse> serviceResponse) {
        Observable<Response<UserListResponse>> observable = MyApplication.getInstance().getService().getFriends();
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxObserver(serviceResponse));
    }
}
