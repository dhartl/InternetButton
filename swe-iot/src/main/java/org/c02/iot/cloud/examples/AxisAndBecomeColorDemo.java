package org.c02.iot.cloud.examples;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.AxisAndBecomeColor;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;

public class AxisAndBecomeColorDemo {
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId, DemoConstants.accessToken);

	public static void main(String[] args) {
		InternetButtonApi button = new InternetButtonImpl(api);
		AxisAndBecomeColor behavior = new AxisAndBecomeColor(button);
		while (true) {
			behavior.run();
		}
	}

}
