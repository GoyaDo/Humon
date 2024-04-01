package com.ysmjjsy.goya.identifier.core.serviceid;

import com.ysmjjsy.goya.identifier.core.IdGenerator;
import com.ysmjjsy.goya.identifier.core.snowflake.SnowflakeIdInfo;

/**
 * @author 77394
 * @description 业务 ID 生成器
 * @className ServiceIdGenerator
 * @date 2024/3/28 15:02
 */
public interface ServiceIdGenerator extends IdGenerator {

    /**
     * 根据 {@param serviceId} 生成雪花算法 ID
     */
    long nextId(long serviceId);

    /**
     * 根据 {@param serviceId} 生成字符串类型雪花算法 ID
     */
    String nextIdStr(long serviceId);

    /**
     * 解析雪花算法
     */
    SnowflakeIdInfo parseSnowflakeId(long snowflakeId);
}
