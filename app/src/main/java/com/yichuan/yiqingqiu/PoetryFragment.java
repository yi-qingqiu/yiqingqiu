package com.yichuan.yiqingqiu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import base.fragment.BaseFragment;

/**
 * @author 易川
 * @time 2017/6/14  15:44
 * @desc ${TODO}
 */

public class PoetryFragment extends BaseFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poetry, container, false);

        return view;
    }
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
