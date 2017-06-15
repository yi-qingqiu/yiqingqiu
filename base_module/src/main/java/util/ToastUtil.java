package util;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author 易川
 *
 * @desc 在主线程子线程都能运行的Toast
 */

public  class ToastUtil {

    public static void showTaost(final Activity context, final String text){
        //判断当前是否是被子线程调用
        if("main".equals(Thread.currentThread().getName())) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }else {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
