package org.c02.iot.cloud.examples;

import java.io.IOException;
import java.util.Arrays;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class ButtonCounterDemo {
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);

	public static void main(String[] args) throws IOException, ParticleException {

		InternetButtonApi button = new InternetButtonImpl(api);
		Arrays.stream(ButtonDirection.values()).forEach(buttonDirection -> {
			try {
				System.out.println("requesting Button Counter " + buttonDirection);
				int buttonCounter = button.getButtonCounter(buttonDirection);
				System.out.println(buttonDirection + " - " + buttonCounter);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		button.resetButtonCounters();

	}
}
