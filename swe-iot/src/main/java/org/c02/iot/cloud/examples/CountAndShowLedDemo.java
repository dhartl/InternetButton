package org.c02.iot.cloud.examples;

import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;

public class CountAndShowLedDemo {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);

	public static void main(String[] args) throws IOException, ParticleException {

		InternetButtonApi button = new InternetButtonImpl(api);
	
		
		CountAndShowLed demo = new CountAndShowLed(button);

		demo.run();

	}
}
