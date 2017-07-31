package pya.marlon.com.friends.presentation.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import butterknife.BindView;
import pya.marlon.com.friends.R;
import pya.marlon.com.friends.data.db.manager.UserManagerSql;
import pya.marlon.com.friends.data.db.model.UserSql;
import pya.marlon.com.friends.data.mapper.UserMapper;
import pya.marlon.com.friends.domain.model.UserBean;
import pya.marlon.com.friends.presentation.fragment.MyFriendsFragment;
import pya.marlon.com.friends.presentation.fragment.MyProfileFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    @BindView(R.id.btvFriends) BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        example();
    }

    private void initView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void transaction(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.menu_my_profile:
                fragment = new MyProfileFragment();
                bottomNavigationView.getMenu().findItem(R.id.menu_my_profile).setChecked(true);
                break;
            case R.id.menu_my_friends:
                fragment = new MyFriendsFragment();
                bottomNavigationView.getMenu().findItem(R.id.menu_my_friends).setChecked(true);
                break;
        }
        transaction(fragment);
        return false;
    }

    private void example() {
        UserManagerSql userManagerSql = new UserManagerSql();
        UserBean userBean = new UserBean(0, "abigail", "estrella", 30);
        UserSql userSql = UserMapper.getInstance().map(userBean);
        userSql.setId(userManagerSql.lastId());
        userManagerSql.createOrUpdate(userSql);

        for (UserSql userSql1 : userManagerSql.getList()) {
            Log.d(TAG, "example: "+ userSql1.toString());
        }
    }
}
