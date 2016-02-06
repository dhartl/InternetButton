package org.c02.iot.behaviour;


import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleException;

public class CountAndPlaySound extends AbstractBehaviour {

	public CountAndPlaySound(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}
	boolean soundplayed=false;
	@Override
	public void run() {
		try {
			
			int buttonCounter = button.getButtonCounter(ButtonDirection.North);
			if (buttonCounter > 0) {
				if (buttonCounter % 10 == 0 && soundplayed==false){
					button.playSound();
					soundplayed=true;
				}
				else if (buttonCounter % 10 !=0 )
				soundplayed=false;
					
			}
			System.out.println(buttonCounter);
		} catch (ParticleException | IOException e) {
			e.printStackTrace();
		}
	}

}
