package in.codeselect.andoidutils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by akhileshkumar on 9/6/17.
 */

public class ResUtil {

    private static ResUtil sInstance;

    private Context mContext;

    private ResUtil(Context context) {
        this.mContext = context;
    }

    public static void init(Context context) {
        sInstance = new ResUtil(context.getApplicationContext());
    }

    private static void checkInit() {
        if (sInstance == null) {
            String resutil = ResUtil.class.getSimpleName();
            throw new RuntimeException("Instance of " + resutil + " not initialized." + " Make sure to call "
                    + resutil + ".init(context) method in you Application class.");
        }
    }

    private String getStringRes(@StringRes int id) {
        return mContext.getString(id);
    }

    private Drawable getDrawableRes(@DrawableRes int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mContext.getDrawable(id);
        } else {
            return mContext.getResources().getDrawable(id);
        }
    }

    private int getColorRes(@ColorRes int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mContext.getColor(id);
        } else {
            return mContext.getResources().getColor(id);
        }
    }

    public static String getString(@StringRes int id) {
        checkInit();
        return sInstance.getStringRes(id);
    }

    public static Drawable getDrawable(@DrawableRes int id) {
        checkInit();
        return sInstance.getDrawableRes(id);
    }

    public static int getColor(@ColorRes int id) {
        checkInit();
        return sInstance.getColorRes(id);
    }


}
