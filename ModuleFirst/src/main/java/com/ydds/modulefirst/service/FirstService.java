package com.ydds.modulefirst.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.ydds.librouter.consts.MFirstConst;
import com.ydds.librouter.services.IFirstService;
import com.ydds.modulefirst.bean.Person;


/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
@Route(path = MFirstConst.MF_SERVICE_FIRST)
public class FirstService implements IFirstService {

    @Override
    public void init(Context context) {

    }

    @Override
    public String getFirstInfo() {
        return "来自ModuleFirst的信息：我是ModuleFirst";
    }

    @Override
    public <T> T getFirstInfo2(String params, Class<T> clazz) {
        Person person = new Person();
        person.name = "ModuleFirst";
        person.from = "火星";
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(person),clazz);
    }
}
