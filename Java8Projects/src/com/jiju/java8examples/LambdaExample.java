package com.jiju.java8examples;

public class LambdaExample {
	public static void main(String args[]){
		(int a, int b)-> { return a+b; }
		() -> System.out.println("Hello World");

		(String s) -> { System.out.println(s); }

		() -> 42

		() -> { return 3.1415 };
	}
}
