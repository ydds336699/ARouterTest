package com.ydds.modulesecond;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.ydds.librouter.RLog;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */

@Route(path = "/ModuleSecond/init")
public class ModuleSecond implements IProvider {

    private static Context appContext;

    @Override
    public void init(Context context) {
        RLog.d("ModuleSecond init");
        appContext = context;
        //初始化其他...
    }

    public static Context getAppContext() {
        return appContext;
    }
}
