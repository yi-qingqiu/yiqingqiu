package com.yichuan.yiqingqiu.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.mine.login.LoginActivity;

import base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author 易川
 * @time 2017/6/14  15:40
 * @desc ${TODO}
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_user_head)
    CircleImageView mIvUserHead;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_user_head})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_user_head :
                showFragmentBottomToTop(getActivity(), LoginActivity.class);
                break;
        }
    }
}
