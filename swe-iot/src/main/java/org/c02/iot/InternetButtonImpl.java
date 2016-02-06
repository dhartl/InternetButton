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
		
		String temp; 
		if(postition < 10)
		{
		temp = "0" + Integer.toString(postition);
		}
		else
		{
			temp = Integer.toString(postition);
		}
		
		String tempColor;
		tempColor = Integer.toString(color.getRed()) + Integer.toString(color.getGreen()) +Integer.toString(color.getBlue());
		
		temp = temp + tempColor;
		
		wrapper.callMethod("led", temp);
		
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
