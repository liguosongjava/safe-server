package com.safe.info.core.util;

import com.safe.info.core.vo.LoginInfo;

/**
 * 方便获取当前登录用户
 */
public class SessionLocal{
    private static ThreadLocal<LoginInfo> local = new ThreadLocal<LoginInfo>();

    /**
     * 设置用户信息
     *
     * @param user
     */
    public static void setUser(LoginInfo user){
        local.set( user );
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public static LoginInfo getUser(){
        return local.get();
    }
}
