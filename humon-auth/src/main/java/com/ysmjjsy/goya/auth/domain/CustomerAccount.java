package com.ysmjjsy.goya.auth.domain;

import com.ysmjjsy.goya.auth.constant.enums.Gender;
import com.ysmjjsy.goya.auth.convertor.enums.GenderConvertor;
import com.ysmjjsy.goya.jpa.base.BaseJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

/**
 * @author 77394
 * @description TODO
 * @className CustomerAccount
 * @date 2024/3/27 16:46
 */
@Entity
@Table(name = "t_customer_account")
@Data
public class CustomerAccount extends BaseJpaEntity implements UserDetails {

    /**
     * 手机号
     */
    @Column(
            nullable = false,
            length = 15,
            unique = true
    )
    private String phone;

    /**
     * 密码
     */
    @Column(
            nullable = false,
            length = 15
    )
    private String password;

    /**
     * 昵称
     */
    @Column(
            nullable = false,
            length = 20
    )
    private String nickName;

    /**
     * 邮箱
     */
    @Column(
            length = 20,
            unique = true
    )
    private String email;

    @Column(
            nullable = false
    )
    private LocalDate birthday;

    /**
     * 身份证号
     */
    @Column(
            length = 18,
            unique = true
    )
    private String idNumber;

    /**
     * 性别
     */
    @Column(
            length = 1
    )
    @Convert(converter = GenderConvertor.class)
    private Gender gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
