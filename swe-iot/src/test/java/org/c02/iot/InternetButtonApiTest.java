package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InternetButtonApiTest {

	private InternetButtonApi internetButtonApi;

	@Mock
	private ParticleApiWrapper particleWrapperApi;

	@Before
	public void setup() {
		Mockito.reset(particleWrapperApi);
		internetButtonApi = new InternetButtonImpl(particleWrapperApi);
	}

	@Test
	public void testPlaySound() throws ParticleException {
		internetButtonApi.playSound();
		Mockito.verify(particleWrapperApi).callMethod("play", null);
	}

	@Test
	public void testSetLedPos3ColorGreen() throws ParticleException {
		internetButtonApi.setLed(3, new Color(0, 255, 0));
		Mockito.verify(particleWrapperApi).callMethod("led", "03000255000");
	}

	@Test
	public void testSetLedPos6ColorBlue() throws ParticleException {
		internetButtonApi.setLed(6, new Color(0, 0, 255));
		Mockito.verify(particleWrapperApi).callMethod("led", "06000000255");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLedNegativePosition() throws ParticleException {
		internetButtonApi.setLed(-1, new Color(0, 0, 255));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLedTooHighPosition() throws ParticleException {
		internetButtonApi.setLed(13, new Color(0, 0, 255));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetLedNoColor() throws ParticleException {
		internetButtonApi.setLed(6, null);
	}
	
	@Test 
	public void testLedOff() throws ParticleException {
		internetButtonApi.allLedsOff();;
		Mockito.verify(particleWrapperApi).callMethod("ledsOff",null);
	}

	@Test
	public void testGetButtonCounterNorth() throws IOException {
		Mockito.when(particleWrapperApi.readVariable("countButton1")).thenReturn(3);
		int counter = internetButtonApi.getButtonCounter(ButtonDirection.North);
		Assert.assertEquals(3, counter);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetButtonCounterInvalid() throws IOException {
		internetButtonApi.getButtonCounter(null);
	}

}
