package com.safe.info.core.pojo;

import java.util.Date;

/**
 * 登录日志
 */
public class LoginLog extends BasePojo{
    private Long customerId;
    private String ip;
    private Date loginTime;

    public LoginLog(Long customerId, String ip, Date loginTime,int state) {
        this.customerId = customerId;
        this.ip = ip;
        this.loginTime = loginTime;
        this.state =state;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "customerId=" + customerId +
                ", ip='" + ip + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
