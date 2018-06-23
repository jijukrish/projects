package com.jiju.java8examples;

public class StateListenerTest {
	public static void main(String args[]){
		StateOwner stateOwner = new StateOwner();

		stateOwner.addStateListener(
		    (oldState, newState) -> System.out.println("State changed")
		);
	}
}
