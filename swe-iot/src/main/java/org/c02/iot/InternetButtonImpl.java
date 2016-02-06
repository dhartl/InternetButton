package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	@Override
	public int getButtonCounter(ButtonDirection button) throws IOException {
		if (button == null) {
			throw new IllegalArgumentException("ButtonDirection darf nicht NULL sein!");
		}
		return wrapper.readVariable("countButton" + button.getDirectionNr());
	}

	@Override
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

	@Override
	public void allLedsOff() throws ParticleException {
		wrapper.callMethod("ledsOff", null);

	}

	@Override
	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	@Override
	public void resetButtonCounters() throws ParticleException {
		wrapper.callMethod("reset", null);
	}

	@Override
	public int getAxisValue(Axis axis) throws IOException {
		if (axis == null) {
			throw new IllegalArgumentException("Keine Aches angegeben!");
		}
		return wrapper.readVariable(axis.getDirection() + "Value");
	}

}
