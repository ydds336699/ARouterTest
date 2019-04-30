package com.ydds.librouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.ydds.librouter.consts.DegradeConst;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/30
 */

@Route(path = DegradeConst.DEGRADE_LOGIN)
public class DegradeServiceImpl implements DegradeService {


    @Override
    public void onLost(Context context, Postcard postcard) {
        RLog.d("DegradeServiceImpl onLost");
    }

    @Override
    public void init(Context context) {

    }
}
