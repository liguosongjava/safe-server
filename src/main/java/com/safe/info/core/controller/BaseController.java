package com.safe.info.core.controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * 控制器基类
 */
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected Integer getParameterInteger(HttpServletRequest httpServletRequest, String paramName,
                                          Integer defaultValue) {
        String paramValue = httpServletRequest.getParameter(paramName);
        if (Strings.isNullOrEmpty(paramValue)) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(paramValue);
            } catch (Exception e) {
                logger.error("", e);
                return defaultValue;
            }
        }
    }

    protected Long getParameterLong(HttpServletRequest httpServletRequest, String paramName,
                                    Long defaultValue) {
        String paramValue = httpServletRequest.getParameter(paramName);
        if (Strings.isNullOrEmpty(paramValue)) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(paramValue);
            } catch (Exception e) {
                logger.error("", e);
                return defaultValue;
            }
        }
    }

    protected Long getParameterDateYYYYMMDD(HttpServletRequest httpServletRequest, String paramName,
                                            Long defaultValue) {
        String paramValue = httpServletRequest.getParameter(paramName);
        if (Strings.isNullOrEmpty(paramValue)) {
            return defaultValue;
        } else {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(paramValue).getTime();
            } catch (Exception e) {
                logger.error("", e);
                return defaultValue;
            }
        }
    }


    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
