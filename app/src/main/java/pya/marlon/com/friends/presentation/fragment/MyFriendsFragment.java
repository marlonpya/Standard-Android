package pya.marlon.com.friends.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.friends.R;
import pya.marlon.com.friends.data.db.manager.UserManagerSql;
import pya.marlon.com.friends.data.mapper.UserMapper;
import pya.marlon.com.friends.data.rest.response.UserListResponse;
import pya.marlon.com.friends.data.rest.service.UserService;
import pya.marlon.com.friends.data.rest.service.repository.UserRepository;
import pya.marlon.com.friends.domain.dto.ServiceResponse;
import pya.marlon.com.friends.presentation.adapter.MyFriendsAdapter;
import pya.marlon.com.friends.util.view.MarginDecorator;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFriendsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = "MyFriendsFragment";
    @BindView(R.id.srlFriends) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rvFriends) RecyclerView recyclerView;
    private MyFriendsAdapter adapter;
    private UserService userService;
    private Subscription subscription;
    private UserManagerSql userManagerSql;

    public MyFriendsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_friends, container, false);
        ButterKnife.bind(this, view);

        initView();
        ui();
        return view;
    }

    private void initView() {
        subscription = Subscriptions.empty();
        swipeRefreshLayout.setOnRefreshListener(this);
        userService = new UserRepository();
        userManagerSql = new UserManagerSql();
    }

    private void ui() {
        adapter = new MyFriendsAdapter(getActivity());
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new MarginDecorator(getActivity()));
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                MyFriendsFragment.this.load();
            }
        });
    }

    private void load() {
        swipeRefreshLayout.setRefreshing(true);
        subscription = userService.getFriends(new ServiceResponse<UserListResponse>() {
            @Override
            public void onSuccess(UserListResponse response) {
                swipeRefreshLayout.setRefreshing(false);
                adapter.load(response.getUsers());
                userManagerSql.createOrUpdate(UserMapper.getInstance().map(response.getUsers()));
            }

            @Override
            public void onError(String message) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e(TAG, "onError: " + message);
            }
        });
    }

    @Override
    public void onRefresh() {
        this.load();
    }

    @Override
    public void onDestroy() {
        if (!subscription.isUnsubscribed()) subscription.unsubscribe();
        super.onDestroy();
    }
}
