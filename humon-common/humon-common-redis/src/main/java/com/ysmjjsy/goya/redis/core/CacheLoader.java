package com.ysmjjsy.goya.redis.core;

/**
 * @author 77394
 * @description TODO
 * @className CacheLoader
 * @date 2024/3/28 14:52
 */
@FunctionalInterface
public interface CacheLoader<T> {

    /**
     * 加载缓存
     *
     * @return
     */
    T load();
}
