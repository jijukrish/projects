package com.journaldev.spring.di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journaldev.spring.di.services.MessageService;

@Component
public class MyApplication {
	//field based dependency injection
	private MessageService msgService;
	
	@Autowired
	public void setService(MessageService service) {
		this.msgService = service;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.msgService.sendMessage(msg, rec);
	}
}
