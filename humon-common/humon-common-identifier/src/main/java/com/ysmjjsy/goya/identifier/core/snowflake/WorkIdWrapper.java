package com.ysmjjsy.goya.identifier.core.snowflake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 77394
 * @description WorkId 包装器
 * @className WorkIdWrapper
 * @date 2024/3/28 15:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkIdWrapper {
    /**
     * 工作ID
     */
    private Long workId;

    /**
     * 数据中心ID
     */
    private Long dataCenterId;
}
