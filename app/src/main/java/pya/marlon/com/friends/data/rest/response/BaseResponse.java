package pya.marlon.com.friends.data.rest.response;

/**
 * Created by marlonpya on 23/07/17.
 */

public class BaseResponse {
    private boolean success;
    private String message;

    public BaseResponse() {}

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
