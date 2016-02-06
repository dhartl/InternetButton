package org.c02.iot.behaviour;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.Axis;
import org.c02.iot.cloud.api.ParticleException;

public class AxisAndBecomeColor extends AbstractBehaviour {

	public AxisAndBecomeColor(InternetButtonApi buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		try {
			int xValue = getColor(Axis.xAxis);
			int yValue = getColor(Axis.yAxis);
			int zValue = getColor(Axis.zAxis);
			Color color = new Color(xValue, yValue, zValue);
			System.out.println("x:" + xValue + " y: " + yValue + " z: " + zValue + " setting color " + color);
			button.setLed(1, color);
		} catch (ParticleException | IOException ex) {
			ex.printStackTrace();
		}
	}

	private int getColor(Axis axis) throws IOException {
		return button.getAxisValue(axis) + 128;
	}

}
