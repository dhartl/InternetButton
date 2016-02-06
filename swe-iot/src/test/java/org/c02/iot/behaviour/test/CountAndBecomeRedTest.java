package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.behaviour.CountAndBecomeRed;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountAndBecomeRedTest {

	@Mock
	private InternetButtonApi internetButtonApi;

	private CountAndBecomeRed behaviour;

	@Before
	public void setup() {
		Mockito.reset(internetButtonApi);
		behaviour = new CountAndBecomeRed(internetButtonApi);
	}

	@Test
	public void testNoButtonPressed() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(0);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(0, 0, 0));
	}

	@Test
	public void testButtonPressed20Times() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(20);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(200, 0, 0));
	}

	@Test
	public void testButtonPressed26Times() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(26);
		behaviour.run();
		Mockito.verify(internetButtonApi).setLed(1, new Color(5, 0, 0));
		Mockito.verify(internetButtonApi).resetButtonCounters();
	}
}
