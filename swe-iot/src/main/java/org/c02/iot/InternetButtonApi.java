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

	public enum Axis {
		xAxis("x"), yAxis("y"), zAxis("z");

		private String direction;

		private Axis(String direction) {
			this.direction = direction;
		}

		public String getDirection() {
			return direction;
		}
	}

	int getButtonCounter(ButtonDirection button) throws IOException;

	void resetButtonCounters() throws ParticleException;

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

	int getAxisValue(Axis axis) throws IOException;
}
