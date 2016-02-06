package org.c02.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleException;

public class CountAndBecomeRed extends AbstractBehaviour {

	public CountAndBecomeRed(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			int buttonCounter = button.getButtonCounter(ButtonDirection.North);
			int red = buttonCounter * 10;
			if (red > 255) {
				red = red % 255;
				System.out.println("resetting button Counters");
				button.resetButtonCounters();
			}
			System.out.println("setting led 1 to rgb(" + red + ",0,0)");
			button.setLed(1, new Color(red, 0, 0));
		} catch (IOException | ParticleException e) {
			e.printStackTrace();
		}
	}

}
