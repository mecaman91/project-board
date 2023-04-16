package com.project.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

// 각종 설정을 잡을 때 사용
@EnableJpaAuditing //감사정보 자동생성 및 업데이트
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("nhs91"); //TODO: 스프링 시큐리티로 인증 기능을 붙이게 될때, 수정하자
    }
}
