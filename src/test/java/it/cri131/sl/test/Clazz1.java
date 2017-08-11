package it.cri131.sl.test;

import it.cri131.sl.SlimLogger;

public class Clazz1 {
	
	private static SlimLogger log = SlimLogger.getLogger(Clazz1.class);
	
	public int method1() {
		log.i("Logging class Clazz1");
		return 1;
	}

}
