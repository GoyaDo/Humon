package com.ysmjjsy.goya.identifier.core;

/**
 * ID 生成器
 * @author 77394
 * @description TODO
 * @className IdGenerator
 * @date 2024/3/28 15:03
 */
public interface IdGenerator {

    /**
     * 下一个 ID
     */
    default long nextId() {
        return 0L;
    }

    /**
     * 下一个 ID 字符串
     */
    default String nextIdStr() {
        return "";
    }
}
