package com.journaldev.spring.di.consumer;

import com.journaldev.spring.di.services.MessageService;

public class MyXMLApplication {
 private MessageService service;
 
 // Set through XMl configuration
 public void setService(MessageService service){
	 this.service = service;
 }
 
 public boolean processMessage(String msg, String rec) {
	 //Some magic like logging, validation etc
	 return this.service.sendMessage(msg, rec);
 }
}
