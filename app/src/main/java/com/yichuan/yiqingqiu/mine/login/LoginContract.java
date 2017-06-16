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
       void showLoading();
        void dismissLoading();
        void closePage();
    }

    interface Presenter extends BasePresenter {
        void qqLogin();
        void phoneLogin();
    }
}
