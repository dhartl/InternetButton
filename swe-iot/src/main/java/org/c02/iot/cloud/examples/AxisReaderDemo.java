package org.c02.iot.cloud.examples;

import java.io.IOException;
import java.util.Arrays;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.Axis;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class AxisReaderDemo {
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);

	public static void main(String[] args) throws IOException, ParticleException {
		InternetButtonApi button = new InternetButtonImpl(api);
		Arrays.stream(Axis.values()).forEach(axis -> {
			try {
				System.out.println("requesting Axis value " + axis);
				int axisValue = button.getAxisValue(axis);
				System.out.println(axis + " - " + axisValue);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		button.resetButtonCounters();

	}
}
