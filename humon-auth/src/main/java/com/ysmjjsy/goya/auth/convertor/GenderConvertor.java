package com.ysmjjsy.goya.auth.convertor;

import com.ysmjjsy.goya.auth.constant.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author 77394
 * @description TODO
 * @className GenderConvertor
 * @date 2024/3/27 16:52
 */
@Converter
public class GenderConvertor implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        return Gender.parseCode(dbData).orElse(Gender.UNKNOWN);
    }
}
