package pya.marlon.com.friends.data.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import pya.marlon.com.friends.domain.model.UserBean;

/**
 * Created by marlonpya on 23/07/17.
 */

public class UserListResponse extends BaseResponse {
    @SerializedName("result")
    List<UserBean> users;

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
