package com.programcreek.helloworld.exception;

public class HelloWorldException extends Exception {
	private String exMessage;
    public HelloWorldException(String message) {
		this.exMessage = message;
	}
    
    public String toString() {
    	return exMessage;
    }
}
