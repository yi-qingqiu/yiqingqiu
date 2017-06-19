package com.yichuan.yiqingqiu.mine;

import android.os.Bundle;
import android.widget.TextView;

import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegeisteActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

    }

    @Override
    public void initView() {
        mTv.setText("456");
    }

    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regeiste;
    }
}
