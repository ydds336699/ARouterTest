package com.ydds.librouter.services;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
public interface IFirstService extends IProvider {

    public String getFirstInfo();

    public <T> T getFirstInfo2(String params, Class<T> clazz);

}
