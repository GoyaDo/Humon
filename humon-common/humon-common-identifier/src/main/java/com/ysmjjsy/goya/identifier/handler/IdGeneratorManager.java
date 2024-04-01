package com.ysmjjsy.goya.identifier.handler;

import com.ysmjjsy.goya.identifier.core.IdGenerator;
import com.ysmjjsy.goya.identifier.core.serviceid.DefaultServiceIdGenerator;
import com.ysmjjsy.goya.identifier.core.serviceid.ServiceIdGenerator;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 77394
 * @description ID 生成器管理
 * @className IdGeneratorManager
 * @date 2024/3/28 15:39
 */
public class IdGeneratorManager {


    /**
     * ID 生成器管理容器
     */
    private static Map<String, IdGenerator> MANAGER = new ConcurrentHashMap<>();

    /**
     * 注册默认 ID 生成器
     */
    static {
        MANAGER.put("default", new DefaultServiceIdGenerator());
    }

    /**
     * 注册 ID 生成器
     */
    public static void registerIdGenerator(@NonNull String resource, @NonNull IdGenerator idGenerator) {
        IdGenerator actual = MANAGER.get(resource);
        if (actual != null) {
            return;
        }
        MANAGER.put(resource, idGenerator);
    }

    /**
     * 根据 {@param resource} 获取 ID 生成器
     */
    public static IdGenerator getIdGenerator(@NonNull String resource) {
        return MANAGER.get(resource);
    }

    /**
     * 获取默认 ID 生成器 {@link DefaultServiceIdGenerator}
     */
    public static ServiceIdGenerator getDefaultServiceIdGenerator() {
        return Optional.ofNullable(MANAGER.get("default")).map(each -> (ServiceIdGenerator) each).orElse(null);
    }
}
