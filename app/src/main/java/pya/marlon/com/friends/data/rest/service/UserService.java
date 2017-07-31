package pya.marlon.com.friends.data.rest.service;

import pya.marlon.com.friends.data.rest.response.UserListResponse;
import pya.marlon.com.friends.domain.dto.ServiceResponse;
import rx.Subscription;

/**
 * Created by marlonpya on 23/07/17.
 */

public interface UserService {

    Subscription getFriends(ServiceResponse<UserListResponse> serviceResponse);
}
