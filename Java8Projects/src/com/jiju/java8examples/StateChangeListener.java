package com.jiju.java8examples;

import java.lang.Thread.State;

public interface StateChangeListener {
	public void onStateChange(State oldState, State newState);
}
