package com.ysmjjsy.goya.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ysmjjsy.goya")
@EntityScan(basePackages = "com.ysmjjsy.goya.auth.domain")
@EnableJpaRepositories(basePackages = "com.ysmjjsy.goya.auth.repository")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
