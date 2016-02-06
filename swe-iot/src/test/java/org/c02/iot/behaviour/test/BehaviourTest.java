package org.c02.iot.behaviour.test;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.behaviour.CountAndShowLed;
import org.junit.Assert;
import org.junit.Test;

public class BehaviourTest {

	@Test
	public void testBehaviour() {

		InternetButtonApi buttonInstance = new InternetButtonApi() {

			@Override
			public int getButtonCounter(ButtonDirection button) {
				if (button == ButtonDirection.North)
					return 17;
				return 0;
			}

			@Override
			public void resetButtonCounters() {
				Assert.fail();
			}

			@Override
			public void setLed(int postition, Color color) {
				Assert.assertEquals(5, postition);
				Assert.assertEquals(new Color(0, 0, 255), color);
			}

			@Override
			public void allLedsOff() {
				Assert.fail();
			}

			@Override
			public void playSound() {
				Assert.fail();
			}

			@Override
			public int getAxisValue(Axis axis) throws IOException {
				Assert.fail();
				return 0;
			}
		};

		CountAndShowLed beh = new CountAndShowLed(buttonInstance);

		beh.run();
	}
}
