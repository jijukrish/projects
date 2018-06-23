package com.jiju.java8examples;

import java.util.Arrays;

public class Java8Lambda {
	public static void main(String args[]){
		Arrays.asList("a","b","d").forEach( e-> {
			System.out.print(e);
			System.out.print(e);
		});
	}

}
