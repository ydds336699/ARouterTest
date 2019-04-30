package com.ydds.librouter;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        Administrator
 * version:       V1.0
 * Date:          2019/4/30
 */
public interface ServiceCallback<T> {

    public void onSuccess(T t);

    public void onFail(String msg);
}
