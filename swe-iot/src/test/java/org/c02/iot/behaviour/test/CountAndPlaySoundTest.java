package org.c02.iot.behaviour.test;

import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.behaviour.CountAndPlaySound;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CountAndPlaySoundTest {

	@Mock
	private InternetButtonApi internetButtonApi;

	private CountAndPlaySound behaviour;

	@Before
	public void setup() {
		Mockito.reset(internetButtonApi);
		behaviour = new CountAndPlaySound (internetButtonApi);
	}

	@Test
	public void testNoButtonPressed() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(0);
		behaviour.run();
		Mockito.verify(internetButtonApi,Mockito.times(0)).playSound();
	}

	@Test
	public void testButtonPressed20Times() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(20);
		behaviour.run();
		Mockito.verify(internetButtonApi).playSound();
	}

	@Test
	public void testButtonPressed26Times() throws IOException, ParticleException {
		Mockito.when(internetButtonApi.getButtonCounter(ButtonDirection.North)).thenReturn(26);
		behaviour.run();
		Mockito.verify(internetButtonApi,Mockito.times(0)).playSound();
	}
}
