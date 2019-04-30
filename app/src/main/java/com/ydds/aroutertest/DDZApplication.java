package com.ydds.aroutertest;

import android.app.Application;

import com.ydds.librouter.ARouterManager;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
public class DDZApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ARouterManager.init(this);
    }
}
