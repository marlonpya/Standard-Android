package pya.marlon.com.friends.data.rest;

import pya.marlon.com.friends.data.rest.response.UserListResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by marlonpya on 23/07/17.
 */

public interface RetrofitService {

    @GET("friends")
    Observable<Response<UserListResponse>> getFriends();
}
