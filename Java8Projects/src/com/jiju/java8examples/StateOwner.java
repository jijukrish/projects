package com.jiju.java8examples;

import java.lang.Thread.State;

public class StateOwner implements StateChangeListener{
	public void addStateListener(StateChangeListener listener) { 
		System.out.println("Implmentation for state listener");
	}

	@Override
	public void onStateChange(State oldState, State newState) {
		// TODO Auto-generated method stub
		
	}
}
