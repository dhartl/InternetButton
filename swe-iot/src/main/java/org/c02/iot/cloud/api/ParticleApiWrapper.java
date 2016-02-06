package org.c02.iot.cloud.api;

import java.io.IOException;

public interface ParticleApiWrapper {

	int readVariable(String variable) throws IOException;

	int callMethod(String method, String parameter) throws ParticleException;

}