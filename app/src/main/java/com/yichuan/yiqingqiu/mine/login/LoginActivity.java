package com.yichuan.yiqingqiu.mine.login;

import android.os.Bundle;

import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.common.ActivityUtils;

import base.activity.BaseActivity;

/**
 * @author 易川
 * @time 2017/6/14  15:19
 * @desc ${TODO}
 */

public class LoginActivity extends BaseActivity{
    private LoginPresenter  mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_frame);
        if(loginFragment==null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), loginFragment, R.id.login_frame);
        }

        mPresenter = new LoginPresenter(new LoginModel(),loginFragment);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
