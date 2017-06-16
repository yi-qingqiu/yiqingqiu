package com.yichuan.yiqingqiu.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Window;

import com.yichuan.yiqingqiu.R;
import com.yichuan.yiqingqiu.app.AppManager;

import base.dialog.CommonToast;
import base.dialog.DialogControl;
import base.dialog.DialogHelp;
import butterknife.ButterKnife;
import util.ToastUtil;


/**
 * @author 易川
 * @time 2017/3/10  8:47
 * @desc ${TOD0}
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseViewInterface
       ,DialogControl {
    protected Context mContext;
    private boolean _isVisible = true;
    private ProgressDialog _waitDialog;
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        mContext = this;
        AppManager.getAppManager().addActivity(this);

        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mInflater = getLayoutInflater();
        ButterKnife.bind(this);
        initView();
        initData();
        init(savedInstanceState);

    }


    protected  int getLayoutId() {

        return 0;
    }

    protected void init(Bundle savedInstanceState) {
    }

    @Override
    protected void onPause() {

        super.onPause();
    }


    @Override
    protected void onResume() {

        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().clearActivityInstance(this);
       // OkGo.getInstance().cancelTag(this);

    }
    /**
     *
     * show dialog
     */
    @Override
    public ProgressDialog showWaitDialog(Context context) {
        return showWaitDialog(context,"加载中...");
    }

    @Override
    public ProgressDialog showWaitDialog(Context context,int resid) {
        return showWaitDialog(context,getString(resid));
    }


    @Override
    public ProgressDialog showWaitDialog(Context context,String message) {
        if (_isVisible) {
            if (_waitDialog == null) {
                _waitDialog = DialogHelp.getWaitDialog(context, message);
            }
            if (_waitDialog != null) {
                _waitDialog.setMessage(message);
                _waitDialog.show();
            }
            return _waitDialog;
        }
        return null;
    }


    @Override
    public void hideWaitDialog() {
        if (_isVisible && _waitDialog != null && _waitDialog.isShowing()) {
            try {
                _waitDialog.dismiss();
                _waitDialog = null;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void showMessageDialog(Context context,String text) {
        DialogHelp.getMessageDialog(context,text).show();
    }

    /**
     *
     * showToast
     */
    public void showToast(int msgResid) {

        CommonToast toast = new CommonToast(this);
        toast.setMessage(getString(msgResid));
        toast.show();
    }

    public void showToast(Activity activity, String message) {
        ToastUtil.showTaost(activity,message);

    }
    //处理后退键的情况
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){

            this.finish();  //finish当前activity
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //从下向上打开activity
    public void showActivtiyBottomToTop(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.bottom_in,R.anim.top_out);

    }

    public void showActivtiyFinishBottomToTop(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
    }

    //从右到左打开
    public void showActivtiyFinishRightToLeft(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.right_in,R.anim.left_out);

    }

    public void showActivtiyRightToLeft(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in,R.anim.left_out);

    }
    //淡入淡出
    public void showActivtiyFinishFadeInOut(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }

    //从左到右关闭

    public void closeActivityLeftToRight(){
        AppManager.getAppManager().finishActivity(this);
        overridePendingTransition(R.anim.left_in,R.anim.right_out);

    }

    //从上到下关闭
    public void closeActivityTopToBottom(){
        AppManager.getAppManager().finishActivity(this);
        overridePendingTransition(R.anim.my_top_in, R.anim.my_bottom_out);

    }

    //淡入淡出关闭页面
    public void closeActivityFadeInOut(){
        AppManager.getAppManager().finishActivity(this);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }



}
