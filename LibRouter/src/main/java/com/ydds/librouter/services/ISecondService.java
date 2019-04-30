package com.ydds.librouter.services;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.ydds.librouter.ServiceCallback;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */

public interface ISecondService extends IProvider {

    public String getSecondInfo();

    public <T> void getSecondInfo(ServiceCallback<T> callback,Class<T> clazz);

    public void setSecondInfo(String info);

    public String getSetInfo();

}
