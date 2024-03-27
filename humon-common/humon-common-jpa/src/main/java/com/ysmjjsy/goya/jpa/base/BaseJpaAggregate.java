package com.ysmjjsy.goya.jpa.base;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.domain.AbstractAggregateRoot;

@MappedSuperclass
public class BaseJpaAggregate<T, A extends AbstractAggregateRoot<A>> extends AbstractAggregateRoot<A>{
}
