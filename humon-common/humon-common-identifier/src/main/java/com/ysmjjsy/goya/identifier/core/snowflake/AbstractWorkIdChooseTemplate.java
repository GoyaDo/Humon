package com.ysmjjsy.goya.identifier.core.snowflake;

import com.ysmjjsy.goya.identifier.utils.SnowflakeIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import cn.hutool.core.date.SystemClock;

/**
 * @author 77394
 * @description 雪花算法模板生成
 * @className AbstractWorkIdChooseTemplate
 * @date 2024/3/28 15:35
 */
@Slf4j
public abstract class AbstractWorkIdChooseTemplate {


    /**
     * 是否使用 {@link SystemClock} 获取当前时间戳
     */
    @Value("${humon.distributed.id.snowflake.is-use-system-clock:false}")
    private boolean isUseSystemClock;

    /**
     * 根据自定义策略获取 WorkId 生成器
     *
     * @return
     */
    protected abstract WorkIdWrapper chooseWorkId();

    /**
     * 选择 WorkId 并初始化雪花
     */
    public void chooseAndInit() {
        // 模板方法模式: 通过抽象方法获取 WorkId 包装器创建雪花算法
        WorkIdWrapper workIdWrapper = chooseWorkId();
        long workId = workIdWrapper.getWorkId();
        long dataCenterId = workIdWrapper.getDataCenterId();
        Snowflake snowflake = new Snowflake(workId, dataCenterId, isUseSystemClock);
        log.info("Snowflake type: {}, workId: {}, dataCenterId: {}", this.getClass().getSimpleName(), workId, dataCenterId);
        SnowflakeIdUtil.initSnowflake(snowflake);
    }
}
