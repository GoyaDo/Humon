package com.ysmjjsy.goya.redis.core;

/**
 * @author 77394
 * @description TODO
 * @className CacheGetIfAbsent
 * @date 2024/3/28 14:51
 */
@FunctionalInterface
public interface CacheGetIfAbsent<T> {

    /**
     * 如果查询结果为空，执行逻辑
     *
     * @param param
     */
    void execute(T param);
}
