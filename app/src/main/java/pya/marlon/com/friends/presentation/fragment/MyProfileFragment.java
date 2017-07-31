package pya.marlon.com.friends.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.friends.R;
import pya.marlon.com.friends.domain.model.UserBean;
import pya.marlon.com.friends.util.constant.Extra;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {
    @BindView(R.id.lblId) TextView lblId;
    @BindView(R.id.lblName) TextView lblName;
    @BindView(R.id.lblLastName) TextView lblLastName;
    @BindView(R.id.lblYear) TextView lblYear;

    public MyProfileFragment() { }
    private UserBean userBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        ButterKnife.bind(this, view);

        if (getActivity().getIntent().hasExtra(Extra.USER)) {
            userBean = (UserBean) getActivity().getIntent().getSerializableExtra(Extra.USER);
            lblId.setText(userBean.getId() + "");
            lblName.setText(userBean.getName());
            lblLastName.setText(userBean.getLastName());
            lblYear.setText(userBean.getYear() + "");
        }

        return view;
    }

}
