package com.ysmjjsy.goya.auth.request;

import com.ysmjjsy.goya.auth.constant.enums.Gender;

import java.time.LocalDate;

/**
 * @author 77394
 * @description TODO
 * @className RegisterCustomerRequest
 * @date 2024/3/28 13:17
 */
public record RegisterCustomerRequest(

        /*
          手机号
         */
        String phone,

        /*
          密码
         */
        String password,

        /*
         * 昵称
         */
        String nickName,

        /*
         * 出生日期
         */
        LocalDate birthday,

        /*
         * 性别
         */
        Gender gender

) {



}
