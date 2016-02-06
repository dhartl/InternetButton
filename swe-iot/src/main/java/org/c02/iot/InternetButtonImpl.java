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
		// TODO Auto-generated method stub
	}

	public void allLedsOff() throws ParticleException {
		wrapper.callMethod("ledsOff",null);

	}

	public void playSound() throws ParticleException {
		wrapper.callMethod("play", null);
	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub

	}

}
