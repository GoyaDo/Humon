package com.ysmjjsy.goya.auth.service.impl;

import com.ysmjjsy.goya.auth.convertor.mapper.CustomerAccountMapper;
import com.ysmjjsy.goya.auth.domain.CustomerAccount;
import com.ysmjjsy.goya.auth.repository.CustomerAccountRepository;
import com.ysmjjsy.goya.auth.request.RegisterCustomerRequest;
import com.ysmjjsy.goya.auth.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 77394
 * @description TODO
 * @className UserServiceImpl
 * @date 2024/3/28 9:11
 */
@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerAccountMapper customerAccountMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerAccount loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerAccountRepository.findCustomerAccountByPhone(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));
    }

    @Override
    public RegisterCustomerRequest registerCustomer(RegisterCustomerRequest request) {
        CustomerAccount customerAccount = customerAccountMapper.convert(request);
        String password = passwordEncoder.encode(request.password());
        customerAccount.setPassword(password);
        return customerAccountMapper.convert(customerAccountRepository.save(customerAccount));
    }
}
