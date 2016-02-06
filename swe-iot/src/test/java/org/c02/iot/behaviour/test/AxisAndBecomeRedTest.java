package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.Axis;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.behaviour.AxisAndBecomeRed;
import org.c02.iot.behaviour.CountAndBecomeRed;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AxisAndBecomeRedTest {

	@Mock
	private InternetButtonApi internetButtonApi;

	private AxisAndBecomeRed behaviour;

	@Before
	public void setup() {
		Mockito.reset(internetButtonApi);
		behaviour = new AxisAndBecomeRed(internetButtonApi);
	}

	@Test
	public void testNegativeAxisValue() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getAxisValue(Axis.xAxis)).thenReturn(-100);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(28, 0, 0));
	}

	@Test
	public void testNullAxisValue() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getAxisValue(Axis.xAxis)).thenReturn(0);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(128, 0, 0));
	}
	
	@Test
	public void testPositiveAxisValue() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getAxisValue(Axis.xAxis)).thenReturn(100);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(228, 0, 0));
	}

}
