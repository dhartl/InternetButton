package org.c02.iot;

import java.awt.Color;

import org.c02.iot.cloud.api.ParticleException;

public interface InternetButtonApi {

	public enum ButtonDirection {
		// Button:
		// 1 2 3 4
		North, South, East, West
	}

	int getButtonCounter(ButtonDirection button);

	void resetButtonCounters();

	/**
	 * Setzt die LED auf der Position auf die angegebene Farbe
	 * 
	 * @param postition
	 *            zwischen 1 und 12
	 * @param color
	 *            nicht NULL
	 * @throws ParticleException
	 */
	void setLed(int postition, Color color) throws ParticleException;

	void allLedsOff() throws ParticleException;

	void playSound() throws ParticleException;
}
