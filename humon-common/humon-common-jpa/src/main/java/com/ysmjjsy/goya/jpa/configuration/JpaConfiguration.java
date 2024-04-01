package com.ysmjjsy.goya.jpa.configuration;

import com.ysmjjsy.goya.jpa.auditor.SpringSecurityAuditorAware;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@AutoConfiguration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new SpringSecurityAuditorAware();
    }

}
