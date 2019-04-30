package com.ydds.librouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ydds.librouter.consts.MFirstConst;
import com.ydds.librouter.consts.MSecondConst;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
public class ARouterManager {

    public static void init(Application application) {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(application);

        //模块初始化
        ARouter.getInstance().build(MFirstConst.MODULE_FIRST).navigation();
        ARouter.getInstance().build(MSecondConst.MODULE_SECOND).navigation();

    }
}
