package it.cri131.sl.test;

import it.cri131.sl.SlimLogger;

public class ClassWithLongerNameThanDefault {
	
	private static SlimLogger log = SlimLogger.getLogger(ClassWithLongerNameThanDefault.class);
	
	public void execute() {
		log.i("In log the classname is truncated at default size");
	}

}
