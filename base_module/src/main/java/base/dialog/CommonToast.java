package base.dialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yichuan.base_module.R;


/**
 * @author 易川
 * @time 2017/3/10  11:11
 * @desc ${TODO}
 */


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CommonToast {
    public static final long DURATION_LONG = 5000L;
    public static final long DURATION_MEDIUM = 3500L;
    public static final long DURATION_SHORT = 2500L;
    private long _duration = 3500l;
    private ToastView _toastVw;

    public CommonToast(Activity activity) {
        init(activity);


    }



    public CommonToast(String message, long l) {
        _duration = l;
        setMessage(message);
    }

    private void init(Activity activity) {
        _toastVw = new ToastView(activity);
        setLayoutGravity(81);
    }


    public void setDuration(long l) {
        _duration = l;
    }

    public void setLayoutGravity(int i) {
        if (i != 0) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2,
                    -2);
            params.gravity = i;
            int j = (int) 32;
            params.setMargins(j, j, j, j);
            _toastVw.setLayoutParams(params);
        }
    }

    public void setMessage(String s) {
        _toastVw.messageTv.setText(s);
    }


    public void show() {
        final ViewGroup content = (ViewGroup) ((Activity) _toastVw.getContext())
                .findViewById(android.R.id.content);
        if (content != null) {
            ObjectAnimator.ofFloat(_toastVw, "alpha", 0.0F).setDuration(0L)
                    .start();
            content.addView(_toastVw);
            ObjectAnimator.ofFloat(_toastVw, "alpha", 0.0F, 1.0F)
                    .setDuration(167L).start();
            _toastVw.postDelayed(new Runnable() {

                @Override
                public void run() {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(_toastVw,
                            "alpha", 1.0F, 0.0F);
                    animator.setDuration(100L);
                    animator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            content.removeView(_toastVw);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }
                    });
                    animator.start();
                }
            }, _duration);
        } else {
            Log.e("error","Toast not shown! Content view is null!");
        }
    }

    private class ToastView extends FrameLayout {

        public TextView messageTv;

        public ToastView(Context context) {
            this(context, null);
        }

        public ToastView(Context context, AttributeSet attributeset) {
            this(context, attributeset, 0);
        }

        public ToastView(Context context, AttributeSet attributeset, int i) {
            super(context, attributeset, i);
            init();
        }

        private void init() {
            LayoutInflater.from(getContext()).inflate(
                    R.layout.widget_view_base_toast, this, true);
            messageTv = (TextView) findViewById(R.id.title_tv);
        }
    }
}
