package pya.marlon.com.friends.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.friends.R;
import pya.marlon.com.friends.domain.model.UserBean;

/**
 * Created by marlonpya on 24/07/17.
 */

public class MyFriendsAdapter extends RecyclerView.Adapter<MyFriendsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<UserBean> friends;

    public MyFriendsAdapter(Context context) {
        this.friends = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    public void load(List<UserBean> friends) {
        this.friends = friends;
        notifyDataSetChanged();
    }

    @Override
    public MyFriendsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_friends, parent, false));
    }

    @Override
    public void onBindViewHolder(MyFriendsAdapter.ViewHolder holder, int position) {
        final UserBean user = friends.get(position);
        holder.lblId.setText(user.getId() + "");
        holder.lblName.setText(user.getName());
        holder.lblLastName.setText(user.getLastName());
        holder.lblYear.setText(user.getYear() + "");
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lblId) TextView lblId;
        @BindView(R.id.lblName) TextView lblName;
        @BindView(R.id.lblLastName) TextView lblLastName;
        @BindView(R.id.lblYear) TextView lblYear;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
