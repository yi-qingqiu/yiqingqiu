package com.yichuan.yiqingqiu.mine.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yichuan.yiqingqiu.R;

import base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: yichuan
 * Created on: 2017/6/4 20:17
 * description:
 */

public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener {
    @BindView(R.id.tv_title1)
    TextView mTvTitle1;
    @BindView(R.id.tv_title2)
    TextView mTvTitle2;
    Unbinder unbinder;
    private LoginContract.Presenter mPresenter;

    public LoginFragment() {
        // Requires empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_page, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void loadingStart() {

        //显示加载
        Log.d("tag", "loadingStart");

    }

    @Override
    public void loadingSucess() {
        Log.d("tag", "loadingSucess");
    }

    @Override
    public void loadingResult() {
        Log.d("tag", "loadingResult");

    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.result(requestCode, resultCode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void initView() {
        Typeface fontFace = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/vae.ttf");
        // 字体文件必须是true type font的格式(ttf)；
        // 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为
        // 这个字体android没有支持,而非你的程序发生了错误

        mTvTitle1.setTypeface(fontFace);
        mTvTitle2.setTypeface(fontFace);

    }

    @Override
    public void initData() {

    }
}
