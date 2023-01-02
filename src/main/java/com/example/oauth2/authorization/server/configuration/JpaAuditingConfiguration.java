package com.example.oauth2.authorization.server.configuration;

import com.example.oauth2.authorization.server.jpa.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditingConfiguration {

	@Bean
	public AuditorAware<Long> auditorAware() {
		return new AuditorAwareImpl();
	}
	
}
