package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.cloud.api.ParticleException;

public interface InternetButtonApi {

	public enum ButtonDirection {

		// Button:
		// 1 2 3 4
		North(1), South(2), East(3), West(4);

		private int directionNr;

		private ButtonDirection(int directionNr) {
			this.directionNr = directionNr;
		}

		public int getDirectionNr() {
			return directionNr;
		}
	}

	int getButtonCounter(ButtonDirection button) throws IOException;

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

	void allLedsOff();

	void playSound() throws ParticleException;
}
