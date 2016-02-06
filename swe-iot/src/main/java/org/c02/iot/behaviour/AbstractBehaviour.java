package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

public abstract class AbstractBehaviour implements Runnable {

	protected InternetButtonApi button;

	public AbstractBehaviour(InternetButtonApi buttonInstance) {
		button = buttonInstance;
	}

}
