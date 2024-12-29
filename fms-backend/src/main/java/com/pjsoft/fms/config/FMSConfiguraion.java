package com.pjsoft.fms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FMSConfiguraion {

	@Bean("primaryBean")
	//@Primary
	@Scope("singleton")
	public EmailBean primaryBean() {

		return new EmailBean("though primary");
	}

	@Bean("secondaryBean")
	@Scope("singleton")
	public EmailBean secondaryBean() {
		return new EmailBean("through secondary");
	}

}
