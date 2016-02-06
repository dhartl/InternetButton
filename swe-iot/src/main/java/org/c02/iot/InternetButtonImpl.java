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

	public int getButtonCounter(ButtonDirection button) throws IOException {
		if (button == null) {
			throw new IllegalArgumentException("ButtonDirection darf nicht NULL sein!");
		}
		return wrapper.readVariable("countButton" + button.getDirectionNr());
	}

	public void setLed(int postition, Color color) throws ParticleException {
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub

	}

}
