package com.safe.info.core.util;


import com.alibaba.fastjson.JSONObject;

import com.safe.info.core.exception.InvalidSessionKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * session操作工具类
 *
 */
@Component
public class SessionUtil {
	private static Logger loggger = LoggerFactory.getLogger(SessionUtil.class);

    //最大缓存时间
    public static final int   MAX_SESSION_AGE      = 86400 * 30; // SESSION有效期，30天

    /**
     * 生成sessionKey
     * @param clientIp
     * @param customerId
     * @return
     */
    public String generateSessionKey(String clientIp, Long customerId) {
        String sessionKey = JSONObject.toJSONString(
                new SessionKey(clientIp, customerId, System.currentTimeMillis()));
        return EncryptUtil.encrypt(sessionKey);
    }

    public long getCustomerIdFromSessionKey(String sessionKey) throws InvalidSessionKeyException {
        String originalString = EncryptUtil.decrypt(sessionKey);
        if (originalString == null) {
            throw new InvalidSessionKeyException();
        }
        SessionKey sessionKeyObject = JSONObject.parseObject(originalString, SessionKey.class);
        return sessionKeyObject.getCustomerId();
    }

    /**
     * 清除session
     * @param customerId
     * @return
     */
    public boolean removeSessionFromCache(long customerId) {
        return true;
    }

    /**
     * 将sessionkey塞到数据库
     * @param customerId
     * @param sessionKey
     * @return
     */
    public boolean putSessionToCache(long customerId, String sessionKey) {
        return true;
    }

    static class SessionKey {
        private String clientIp;
        private long   customerId;
        private long   loginTime;

        public SessionKey() {
            super();
        }

        public SessionKey(String clientIp, long customerId, long loginTime) {
            super();
            this.clientIp = clientIp;
            this.customerId = customerId;
            this.loginTime = loginTime;
        }
        public String getClientIp() {
            return clientIp;
        }
        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }
        public long getCustomerId() {
            return customerId;
        }
        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }
        public long getLoginTime() {
            return loginTime;
        }
        public void setLoginTime(long loginTime) {
            this.loginTime = loginTime;
        }

    }
}
