package pya.marlon.com.friends.domain.dto;

import pya.marlon.com.friends.data.rest.response.BaseResponse;

/**
 * Created by marlonpya on 23/07/17.
 */

public interface ServiceResponse<T extends BaseResponse> {
    void onSuccess(T response);
    void onError(String message);
}
