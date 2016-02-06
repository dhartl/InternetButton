package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.Axis;
import org.c02.iot.behaviour.AxisAndBecomeColor;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AxisAndBecomeColorTest {

	@Mock
	private InternetButtonApi internetButtonApi;

	private AxisAndBecomeColor behaviour;

	@Before
	public void setup() {
		Mockito.reset(internetButtonApi);
		behaviour = new AxisAndBecomeColor(internetButtonApi);
	}

	@Test
	public void testAxisAndBecomeColor() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getAxisValue(Axis.xAxis)).thenReturn(-100);
		Mockito.when(internetButtonApi.getAxisValue(Axis.yAxis)).thenReturn(50);
		Mockito.when(internetButtonApi.getAxisValue(Axis.zAxis)).thenReturn(127);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(28, 178, 255));
	}
}
