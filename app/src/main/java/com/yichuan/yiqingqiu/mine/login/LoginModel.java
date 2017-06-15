package com.yichuan.yiqingqiu.mine.login;

import android.widget.Toast;

import com.yichuan.yiqingqiu.UserBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * author: yichuan
 * Created on: 2017/6/4 19:57
 * description:
 */

public class LoginModel {


    public void toLogin(String phone,String password) {
        UserBean user = new UserBean();
        user.setUsername(phone);
        user.setPassword(password);
        user.setMobilePhoneNumber("13082961788");
        user.setEmail("384219266@qq.com");

        user.signUp(new SaveListener<UserBean>() {

            @Override
            public void done(UserBean userBean, BmobException e) {
                if(e==null) {
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
