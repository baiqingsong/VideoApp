package com.dawn.videoapp.ui;

import android.app.Application;

import com.dawn.videoapp.togic.util.Utils;

/**
 * Created by 90449 on 2017/6/7.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
