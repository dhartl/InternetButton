package org.c02.iot;

import java.awt.Color;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		return 0;
	}

	public void setLed(int postition, Color color) throws ParticleException {

		if (postition < 1 || postition > 12 || color == null) {
			throw new IllegalArgumentException();

		}

		String parameter = integerTo3Chars(2, postition) + integerTo3Chars(3, color.getRed())
				+ integerTo3Chars(3, color.getGreen()) + integerTo3Chars(3, color.getBlue());
		wrapper.callMethod("led", parameter);

	}

	private String integerTo3Chars(int count, int color) {
		return String.format("%0" + count + "d", color);
	}

	public void allLedsOff() throws ParticleException {
		wrapper.callMethod("ledsOff", null);

	}

	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub

	}

}
