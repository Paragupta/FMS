package com.pjsoft.fms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import jakarta.annotation.PostConstruct;

public class EmailBean {

	EmailBody emailBody;

	@Autowired
	ApplicationContext applicationContext;

	String source;

	public EmailBean(String source) {
		this.source = source;
		System.out.println("Inside Email Bean Construction" + source);
	}

	@PostConstruct
	private void setupEmail() {
		emailBody = (EmailBody) applicationContext.getBean("EmailBody");
	}

	public EmailBody getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(EmailBody emailBody) {
		this.emailBody = emailBody;
	}
}
