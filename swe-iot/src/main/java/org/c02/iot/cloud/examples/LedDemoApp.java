package org.c02.iot.cloud.examples;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class LedDemoApp {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);

	public static void main(String[] args) throws IOException, ParticleException {

		InternetButtonApi button = new InternetButtonImpl(api);
		
		button.setLed(6, new Color(0, 0, 255));
		button.setLed(8, new Color(255, 0, 255));
				
		button.allLedsOff();

	}
}
