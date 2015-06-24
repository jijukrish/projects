package com.journaldev.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.journaldev.spring.di.configuration.DIConfiguration;
import com.journaldev.spring.di.consumer.MyApplication;

public class ClientApplication {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		app.processMessage("Hi Jiju", "jijukrishnan@hotmail.com");
		context.close();
	}
}
