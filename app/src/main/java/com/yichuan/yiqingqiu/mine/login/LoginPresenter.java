package com.yichuan.yiqingqiu.mine.login;

/**
 * author: yichuan
 * Created on: 2017/6/4 19:51
 * description:
 */

public class LoginPresenter implements LoginContract.Presenter{
    LoginContract.View view;

    public LoginPresenter(LoginContract.View view){
       this.view = view;
        view.setPresenter(this);

    }

    @Override
    public void qqLogin() {

    }

    @Override
    public void phoneLogin() {

    }

    @Override
    public void start() {

    }
}
