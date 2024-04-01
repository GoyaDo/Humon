package com.ysmjjsy.goya.auth.service;

import com.ysmjjsy.goya.auth.request.RegisterCustomerRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 77394
 * @description TODO
 * @className UserService
 * @date 2024/3/28 9:11
 */
public interface CustomerAccountService extends UserDetailsService {

    /**
     * 注册
     * @param request 请求信息
     * @return 注册结果
     */
    RegisterCustomerRequest registerCustomer(RegisterCustomerRequest request);
}
