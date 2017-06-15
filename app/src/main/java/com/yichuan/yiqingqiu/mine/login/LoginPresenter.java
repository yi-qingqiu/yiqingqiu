package com.yichuan.yiqingqiu.mine.login;

/**
 * author: yichuan
 * Created on: 2017/6/4 19:51
 * description:
 */

public class LoginPresenter implements LoginContract.Presenter{
    LoginModel loginModel;

    public LoginPresenter(LoginModel loginModel,LoginContract.View loginView){
       this.loginModel = loginModel;
        loginView.setPresenter(this);

    }


    @Override
    public void login(String phone,String password) {

        loginModel.toLogin(phone,password);

    }

    @Override
    public void loginResult() {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void start() {

    }
}
