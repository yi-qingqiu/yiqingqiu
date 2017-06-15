package com.yichuan.yiqingqiu.mine.login;


import com.yichuan.yiqingqiu.base.BasePresenter;
import com.yichuan.yiqingqiu.base.BaseView;

/**
 * author: yichuan
 * Created on: 2017/6/4 19:49
 * description:
 */

public interface LoginContract {
    interface  View extends BaseView<Presenter> {
        void loadingStart();
        void loadingSucess();
        void loadingResult();
    }

    interface Presenter extends BasePresenter {
        void login(String phone, String password);
        void loginResult();
        void result(int requestCode, int resultCode);

    }
}
