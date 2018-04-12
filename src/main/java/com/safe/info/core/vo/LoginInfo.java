package com.safe.info.core.vo;

import java.io.Serializable;

/**
 * 登录信息
 */
public class LoginInfo implements Serializable {
    private long customerId;
    private int code;
    private String msg;
    private String name;
    private String loginNo;

    public LoginInfo() {
        this.code = 0;
        this.msg = "登录成功";
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "customerId=" + customerId +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                ", loginNo='" + loginNo + '\'' +
                '}';
    }
}
