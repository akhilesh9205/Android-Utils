package in.codeselect.andoidutils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;

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
        return AppCompatResources.getDrawable(mContext, id);
    }

    private int getColorRes(@ColorRes int id){
        return ContextCompat.getColor(mContext, id);
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
