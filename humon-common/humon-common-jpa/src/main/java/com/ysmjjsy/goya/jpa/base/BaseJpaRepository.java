package com.ysmjjsy.goya.jpa.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author 77394
 * @description TODO
 * @className BaseJpaRepository
 * @date 2024/3/27 11:04
 */
@NoRepositoryBean
public interface BaseJpaRepository <T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, QuerydslPredicateExecutor<T> {
}
