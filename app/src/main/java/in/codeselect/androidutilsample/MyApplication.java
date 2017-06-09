package in.codeselect.androidutilsample;

import android.app.Application;

import in.codeselect.andoidutils.ResUtil;

/**
 * Created by akhileshkumar on 9/6/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ResUtil.init(this);
    }
}
