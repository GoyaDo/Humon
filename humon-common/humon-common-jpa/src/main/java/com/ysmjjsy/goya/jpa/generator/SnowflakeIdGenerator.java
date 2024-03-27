package com.ysmjjsy.goya.jpa.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author 77394
 * @description TODO
 * @className SnowflakeIdGenerator
 * @date 2024/3/27 10:58
 */
public class SnowflakeIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return null;
    }
}
