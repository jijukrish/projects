package com.jiju.java8examples;

import java.util.Arrays;
import java.util.List;

public class Java8ArrayListExample {
	public static void main(String args[]) {
		List<String> features = Arrays.asList("Lambdas","Default Method","Stream API","Date and Time API");
		features.forEach(n -> System.out.println(n)); // Even better use Method reference feature of Java 8 // method reference is denoted by :: (double colon) operator // looks similar to score resolution operator of C++ features.forEach(System.out::println);
		
		List<String> subfeatures = Arrays.asList("Jiju","test","Cook");
		
		subfeatures.forEach(n -> System.out.println(n));
	}
}
