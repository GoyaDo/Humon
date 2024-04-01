package com.ysmjjsy.goya.redis.configuration;

import com.ysmjjsy.goya.redis.RedisKeySerializer;
import com.ysmjjsy.goya.redis.StringRedisTemplateProxy;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author 77394
 * @description 缓存配置自动装配
 * @className CacheAutoConfiguration
 * @date 2024/3/28 14:48
 */
@AutoConfiguration
@RequiredArgsConstructor
@EnableConfigurationProperties({RedisDistributedProperties.class, BloomFilterPenetrateProperties.class})
public class CacheAutoConfiguration {

    private final RedisDistributedProperties redisDistributedProperties;

    /**
     * 创建 Redis Key 序列化器，可自定义 Key Prefix
     */
    @Bean
    public RedisKeySerializer redisKeySerializer() {
        String prefix = redisDistributedProperties.getPrefix();
        String prefixCharset = redisDistributedProperties.getPrefixCharset();
        return new RedisKeySerializer(prefix, prefixCharset);
    }

    /**
     * 防止缓存穿透的布隆过滤器
     */
    @Bean
    @ConditionalOnProperty(prefix = BloomFilterPenetrateProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
    public RBloomFilter<String> cachePenetrationBloomFilter(RedissonClient redissonClient, BloomFilterPenetrateProperties bloomFilterPenetrateProperties) {
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter(bloomFilterPenetrateProperties.getName());
        cachePenetrationBloomFilter.tryInit(bloomFilterPenetrateProperties.getExpectedInsertions(), bloomFilterPenetrateProperties.getFalseProbability());
        return cachePenetrationBloomFilter;
    }

    @Bean
    // 静态代理模式: Redis 客户端代理类增强
    public StringRedisTemplateProxy stringRedisTemplateProxy(RedisKeySerializer redisKeySerializer,
                                                             StringRedisTemplate stringRedisTemplate,
                                                             RedissonClient redissonClient) {
        stringRedisTemplate.setKeySerializer(redisKeySerializer);
        return new StringRedisTemplateProxy(stringRedisTemplate, redisDistributedProperties, redissonClient);
    }
}
