package com.safe.info.core.config;

import com.safe.info.core.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 服务启动加载数据库系统数据到redis
 */
@Component
public class SysConfigStartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SysConfigStartupRunner.class);
    @Autowired
    RedisService redisService;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("加载数据库配置到redis>>>>>>>>>>>>>>>>>>>>>>>>>>start");
        redisService.set("jkjkjkjkjkjkjk","geregergegrgegrgerger");
        logger.info("加载数据库配置到redis>>>>>>>>>>>>>>>>>>>>>>>>>>end");
    }
}
