package com.journaldev.spring.di.services;

public class EmailService implements MessageService{

		public boolean sendMessage(String msg, String rec) {
			System.out.println("Email message "+ msg + "sent to" + rec);
			return true;
		}
}
