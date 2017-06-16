package com.yichuan.yiqingqiu.mine.login;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yichuan.yiqingqiu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 易川
 * @time 2017/6/14  15:19
 * @desc ${TODO}
 */

public class LoginActivity extends com.yichuan.yiqingqiu.base.BaseActivity {
    @BindView(R.id.ll_app_name)
    LinearLayout mLlAppName;
    @BindView(R.id.iv_qq_login)
    ImageView mIvQqLogin;
    @BindView(R.id.iv_wechat_login)
    ImageView mIvWechatLogin;
    @BindView(R.id.iv_weibo_login)
    ImageView mIvWeiboLogin;
    @BindView(R.id.ll_three_login)
    LinearLayout mLlThreeLogin;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_regeist)
    Button mBtnRegeist;
    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.tv_title1)
    TextView mTvTitle1;
    @BindView(R.id.tv_title2)
    TextView mTvTitle2;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
      //  new LoginPresenter(this);
        mPresenter.start();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        Typeface fontFace = Typeface.createFromAsset(getAssets(),
                "fonts/vae.ttf");
        // mTvTitle1 = (TextView) findViewById(R.id.tv_title1);
        // mTvTitle2 = (TextView) findViewById(R.id.tv_title2);
        //  mTvTitle1.setTypeface(fontFace);
        //  mTvTitle2.setTypeface(fontFace);



    }

    @Override
    public void initData() {

    }

   /* @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }*/

    @OnClick({R.id.iv_qq_login, R.id.iv_wechat_login, R.id.iv_weibo_login, R.id.btn_login, R.id.btn_regeist, R.id.iv_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_qq_login:
                break;
            case R.id.iv_wechat_login:
                break;
            case R.id.iv_weibo_login:
                break;
            case R.id.btn_login:
                break;
            case R.id.btn_regeist:
                break;
            case R.id.iv_close:
              //  closePage();
                break;
        }
    }
}
