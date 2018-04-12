package com.safe.info.core.util;

/**
 * 环境工具
 */
public class SystemUtil {
    public SystemUtil() {
    }
    public static boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
