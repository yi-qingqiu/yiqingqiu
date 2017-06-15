package base.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * @author 易川
 * @time 2017/3/10  10:53
 * @desc ${TODO}
 */


public interface DialogControl {

    public abstract void hideWaitDialog();

    public abstract ProgressDialog showWaitDialog(Context context);

    public abstract ProgressDialog showWaitDialog(Context context, int resid);

    public abstract ProgressDialog showWaitDialog(Context context, String text);

    public abstract void showMessageDialog(Context context, String text);
}
