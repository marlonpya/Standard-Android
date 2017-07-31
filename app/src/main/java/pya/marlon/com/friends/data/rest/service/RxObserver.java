package pya.marlon.com.friends.data.rest.service;

import android.util.Log;

import pya.marlon.com.friends.data.rest.response.BaseResponse;
import pya.marlon.com.friends.domain.dto.ServiceResponse;
import pya.marlon.com.friends.util.constant.Constant;
import pya.marlon.com.friends.util.helper.Utils;
import retrofit2.Response;
import rx.Observer;

/**
 * Created by marlonpya on 23/07/17.
 */

public class RxObserver implements Observer<Response<? extends BaseResponse>> {
    private String tag = "RxObserver";
    private ServiceResponse serviceResponse;

    public RxObserver(ServiceResponse<? extends BaseResponse> serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

    public RxObserver(ServiceResponse<? extends BaseResponse> serviceResponse, String tag) {
        this.serviceResponse = serviceResponse;
        this.tag = tag;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(tag, "onError: " + e.getMessage(), e);
        serviceResponse.onError(Constant.Connection.Error.ERROR_CONNECTION);
    }

    @Override
    public void onNext(Response<? extends BaseResponse> response) {
        if (response != null) {
            if (response.isSuccessful()) {
                if (response.code() == 200) {
                    if (response.body().isSuccess()) {
                        Log.d(tag, "onNext: " + response.body().toString());
                        serviceResponse.onSuccess(response.body());
                    } else {
                        serviceResponse.onError(Utils.getContent(response.body().getMessage()));
                    }
                }
            }
        } else {
            serviceResponse.onError(Constant.Connection.Error.NOT_CONNECTION);
        }
    }
}
