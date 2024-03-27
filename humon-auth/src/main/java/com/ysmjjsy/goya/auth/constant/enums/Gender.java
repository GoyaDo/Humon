package com.ysmjjsy.goya.auth.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author 77394
 * @description TODO
 * @className Gender
 * @date 2024/3/27 16:50
 */
@Getter
@AllArgsConstructor
public enum Gender {

    MAN(1, "男"),
    WOMAN(2, "女"),
    UNKNOWN(3, "未知");

    private final Integer code;

    private final String name;

    public static Optional<Gender> parseCode(Integer code) {
        return Arrays.stream(Gender.values()).filter(g -> Objects.equals(g.getCode(), code)).findFirst();
    }
}
