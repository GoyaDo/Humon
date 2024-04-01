package com.ysmjjsy.goya.security.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.SpringSecurityMessageSource;

import java.util.Arrays;

/**
 * @author 77394
 * @description TODO
 * @className HumonAuthenticationProvider
 * @date 2024/3/28 17:15
 */
public class HumonAuthenticationProvider implements AuthenticationProvider,InitializingBean,MessageSourceAware {

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //getName()方法被Authentication从Principal接口处继承
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        //这个条件通常会调用UserDetailsService和PasswordEncoder用来调试用户名和密码
        if("mbw".equals(username) && "12345".equals(password)){
            return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
        }else {
            throw new AuthenticationCredentialsNotFoundException("Error in authentication!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }
}
