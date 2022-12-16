package com.nitara.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {

	public static final long WAIT = 60;
	
	public static final long OTP_WAIT = 15;

	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

	}

}
