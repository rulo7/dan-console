package es.raul.app.presentation.tools;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by raulcobos on 22/3/16.
 */
public class DeviceSizeUtils {

    private DeviceSizeUtils(){
        //Empty private constructor for no errors in sonar
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getPxFromDp(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static int getPxFromSp(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }
}
