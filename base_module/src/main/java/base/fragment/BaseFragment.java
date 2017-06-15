package base.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yichuan.base_module.R;

import base.dialog.DialogControl;
import base.dialog.DialogHelp;



/**
 * @author 易川
 * @time 2017/3/10  9:46
 * @desc 碎片基类
 */

public abstract class BaseFragment extends Fragment implements BaseFragmentInterface ,DialogControl {
    protected LayoutInflater mInflater;
    private boolean _isVisible = true;
    private ProgressDialog _waitDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.mInflater = inflater;
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();


    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      //  OkGo.getInstance().cancelTag(this);
    }


    @Override
    public void showMessageDialog(Context context, String text) {
        DialogHelp.getMessageDialog(context,text).show();
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

    //从下向上打开activity
    public void showFragmentBottomToTop(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.bottom_in,R.anim.top_out);

    }

    public void showFragmentFinishBottomToTop(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
    }


    //从右到左打开
    public void showFragmentFinishRightToLeft(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.right_in,R.anim.left_out);

    }

    public void showFragmentRightToLeft(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in,R.anim.left_out);

    }

    //淡入淡出
    public void showFragmentFinishFadeInAndOut(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }

    public void showFragmentFadeInAndOut(Activity activity, Class<?> cls){
        Intent intent = new Intent(activity,cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }


}
