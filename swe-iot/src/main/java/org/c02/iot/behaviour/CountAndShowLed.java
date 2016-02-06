package org.c02.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleException;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			int buttonCounter = button.getButtonCounter(ButtonDirection.North);
			System.out.println(buttonCounter);
			if(buttonCounter > 0){
				if(buttonCounter%12==0){
					buttonCounter=12;
				}
				else{
					buttonCounter=buttonCounter%12;
				}
				System.out.println(buttonCounter);
				button.setLed(buttonCounter, new Color(255, 0, 255));
			}
		} catch (ParticleException | IOException e) {
			e.printStackTrace();
		}
	}

}
