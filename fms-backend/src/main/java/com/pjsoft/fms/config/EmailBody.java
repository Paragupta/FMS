package com.pjsoft.fms.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("EmailBody")
@Lazy
public class EmailBody {

	public EmailBody() {
		System.out.println("Inside Email body construction");
	}

}
