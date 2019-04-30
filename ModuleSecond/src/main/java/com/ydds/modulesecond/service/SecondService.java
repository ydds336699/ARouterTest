package com.ydds.modulesecond.service;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.ydds.librouter.ServiceCallback;
import com.ydds.librouter.consts.MSecondConst;
import com.ydds.librouter.services.ISecondService;
import com.ydds.modulesecond.bean.Man;


/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
@Route(path = MSecondConst.MS_SERVICE_SECOND)
public class SecondService implements ISecondService {

    private static String settInfo = "未设置";

    @Override
    public void init(Context context) {
        if (context instanceof Activity) {
            Toast.makeText(context, "laji", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public String getSecondInfo() {
        return "来自ModuleSecond的信息：我是ModuleSecond";
    }

    @Override
    public <T> void getSecondInfo(final ServiceCallback<T> callback, final Class<T> clazz) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    final Man man = new Man();
                    man.name = "ModuleSecond";
                    man.from = "西伯利亚";
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            callback.onSuccess(gson.fromJson(gson.toJson(man), clazz));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void setSecondInfo(String info) {
        settInfo = info;
    }

    @Override
    public String getSetInfo() {
        String str=new String(settInfo);
        settInfo="未设置";
        return str;
    }
}
