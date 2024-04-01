package com.ysmjjsy.goya.redis.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author 77394
 * @description TODO
 * @className RedisDistributedProperties
 * @date 2024/3/28 14:49
 */
@Data
@ConfigurationProperties(prefix = RedisDistributedProperties.PREFIX)
public class RedisDistributedProperties {

    public static final String PREFIX = "humon.cache.redis";

    /**
     * Key 前缀
     */
    private String prefix = "";

    /**
     * Key 前缀字符集
     */
    private String prefixCharset = "UTF-8";

    /**
     * 默认超时时间
     */
    private Long valueTimeout = 30000L;

    /**
     * 时间单位
     */
    private TimeUnit valueTimeUnit = TimeUnit.MILLISECONDS;
}
