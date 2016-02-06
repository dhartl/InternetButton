package org.c02.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.Axis;
import org.c02.iot.cloud.api.ParticleException;

public class AxisAndBecomeRed extends AbstractBehaviour {

	public AxisAndBecomeRed(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			int axisCounter = button.getAxisValue(Axis.xAxis);
			int red = axisCounter + 128;
			System.out.println("X Axis: " + axisCounter);
			button.setLed(1, new Color(red, 0, 0));
		} catch (IOException | ParticleException e) {
			e.printStackTrace();
		}
	}

}
