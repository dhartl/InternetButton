package org.c02.iot;

import java.awt.Color;

public interface InternetButtonApi {

	public enum ButtonDirection {
		// Button:
		//1     2      3     4
		North, South, East, West
	}

	int getButtonCounter(ButtonDirection button);
	
	void resetButtonCounters();
	
	void setLed(int postition, Color color);
	
	void allLedsOff();
	
	void playSound();
}
