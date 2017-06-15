package base.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/**
 * @author 易川
 * @time 2017/6/9  15:23
 * @desc ${TODO}
 */

public class CommonDialogUtil {

    public static  void getCommonDialog(final Context context, String title,
                                        String message, String positive, String negative, final ICommonDialog commonDialog){
        if(TextUtils.isEmpty(positive)&&TextUtils.isEmpty(negative)) {
            positive = "确定";
            negative = "取消";
        }
        final CommonDialog.Builder builder = new CommonDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               commonDialog.positive();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                commonDialog.negetive();
                dialog.dismiss();

            }
        });

        builder.create().show();


    }

}
