package com.ysmjjsy.goya.redis.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 77394
 * @description TODO
 * @className BloomFilterPenetrateProperties
 * @date 2024/3/28 14:48
 */
@Data
@ConfigurationProperties(prefix = BloomFilterPenetrateProperties.PREFIX)
public class BloomFilterPenetrateProperties {

    public static final String PREFIX = "humon.cache.redis.bloom-filter.default";

    /**
     * 布隆过滤器默认实例名称
     */
    private String name = "cache_penetration_bloom_filter";

    /**
     * 每个元素的预期插入量
     */
    private Long expectedInsertions = 64000L;

    /**
     * 预期错误概率
     */
    private Double falseProbability = 0.03D;
}
