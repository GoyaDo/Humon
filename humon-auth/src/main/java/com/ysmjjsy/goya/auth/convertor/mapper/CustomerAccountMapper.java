package com.ysmjjsy.goya.auth.convertor.mapper;

import com.ysmjjsy.goya.auth.domain.CustomerAccount;
import com.ysmjjsy.goya.auth.request.RegisterCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author 77394
 * @description TODO
 * @className CustomerAccountMapper
 * @date 2024/3/28 13:22
 */
@Mapper(componentModel = "spring")
public interface CustomerAccountMapper {

    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "gender", target = "gender")
    CustomerAccount convert(RegisterCustomerRequest request);

    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "gender", target = "gender")
    RegisterCustomerRequest convert(CustomerAccount customerAccount);
}
