package com.jiju.java8examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
	public static void main(String ... args){
		List<Apple> inventory =Arrays.asList(new Apple(80,"green"),
				new Apple(155,"green"),new Apple(120,"Red"));
	

List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
System.out.println(greenApples);
System.out.println(heavyApples);
	}
public static boolean isGreenApple(Apple apple){
	return "green".equals(apple.getColor());
}

public static boolean isHeavyApple(Apple apple) {
    return apple.getWeight() > 150;
}
public static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p){
	List<Apple> result = new ArrayList<>();
	for(Apple apple:inventory){
		if(p.test(apple)){
			result.add(apple);
		}
	}
	return result;
}

public static List<Apple> filterHeavyApples(List<Apple> inventory){
    List<Apple> result = new ArrayList<>();
    for (Apple apple: inventory){
        if (apple.getWeight() > 150) {
            result.add(apple);
        }
    }
    return result;
}
	
	
	
	
	
	
	
public static class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
               "color='" + color + '\'' +
               ", weight=" + weight +
               '}';
    }
}

}
