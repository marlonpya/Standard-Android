package pya.marlon.com.friends.data.mapper;

import pya.marlon.com.friends.data.db.model.UserSql;
import pya.marlon.com.friends.domain.model.UserBean;

/**
 * Created by marlonpya on 25/07/17.
 */


public class UserMapper extends Mapper<UserBean, UserSql> {
    private static UserMapper instance;

    private UserMapper(){ }

    public static UserMapper getInstance() {
        return instance == null ? new UserMapper() : instance;
    }

    @Override
    public UserSql map(UserBean value) {
        return new UserSql(value.getId(), value.getName(), value.getLastName(), value.getYear());
    }

    @Override
    public UserBean reverseMap(UserSql value) {
        return new UserBean(value.getId(), value.getName(), value.getLastName(), value.getYear());
    }
}
