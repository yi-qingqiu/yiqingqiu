package com.yichuan.yiqingqiu.home;


import cn.bmob.v3.BmobObject;

/**
 * @author 易川
 * @time 2017/6/15  8:58
 * @desc ${TODO}
 */

public class HomeAdBean extends BmobObject {
    private  String image_url;
    private  String destinations_url;
    private String destinations_name;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDestinations_url() {
        return destinations_url;
    }

    public void setDestinations_url(String destinations_url) {
        this.destinations_url = destinations_url;
    }

    public String getDestinations_name() {
        return destinations_name;
    }

    public void setDestinations_name(String destinations_name) {
        this.destinations_name = destinations_name;
    }
}
