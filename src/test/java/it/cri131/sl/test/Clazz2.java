package it.cri131.sl.test;

import it.cri131.sl.SlimLogger;

public class Clazz2 {

	private static SlimLogger log = SlimLogger.getLogger(Clazz2.class);
	
	public String method2() {
		log.i("Logging class Clazz2");
		return "hi!";
	}
	
}
