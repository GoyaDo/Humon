package com.ysmjjsy.goya.auth.controller;

import com.ysmjjsy.goya.auth.request.RegisterCustomerRequest;
import com.ysmjjsy.goya.auth.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 77394
 * @description TODO
 * @className CustomerAccountController
 * @date 2024/3/28 9:13
 */
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @PostMapping("/register")
    public ResponseEntity<RegisterCustomerRequest> registerCustomer(@RequestBody RegisterCustomerRequest request){
        return ResponseEntity.ok(customerAccountService.registerCustomer(request));
    }
}
