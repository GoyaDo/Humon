package com.ysmjjsy.goya.auth.repository;

import com.ysmjjsy.goya.auth.domain.CustomerAccount;
import com.ysmjjsy.goya.jpa.base.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author 77394
 * @description TODO
 * @className CustomerRepository
 * @date 2024/3/28 9:12
 */
@Repository
public interface CustomerAccountRepository extends BaseJpaRepository<CustomerAccount,Long> {

    Optional<CustomerAccount> findCustomerAccountByPhone(String phone);
}
