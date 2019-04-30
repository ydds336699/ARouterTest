package com.ydds.librouter.interceptor;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.ydds.librouter.RLog;
import com.ydds.librouter.consts.MFirstConst;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        Administrator
 * version:       V1.0
 * Date:          2019/4/29
 */
@Interceptor(priority = 1)
public class LoginInterceptor implements IInterceptor {

    private Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        RLog.d("LoginInterceptor process");
        if (MFirstConst.MF_ACTIVITY_FIRST.equals(postcard.getPath())) {
            RLog.d("LoginInterceptor interrupt");
            Toast.makeText(context, "拦截了跳转", Toast.LENGTH_SHORT).show();
            callback.onInterrupt(null);
        } else {
            RLog.d("LoginInterceptor continue");
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        RLog.d("LoginInterceptor init");
        this.context = context;
    }

}
