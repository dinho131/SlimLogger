package it.cri131.sl.test;

import org.junit.Test;

import it.cri131.sl.SlimLogger;

public class Test1 {
	
	private static SlimLogger log = SlimLogger.getLogger(Test1.class);

	@Test
	public void simpleTest() {
		log.i("----- Test1.simpleTest START -----");
		log.e("ERROR LOGGER");
		log.w("WARN LOGGER");
		log.i("INFO LOGGER");
		log.d("DEBUG LOGGER");
		log.i("----- Test1.simpleTest END   -----");
	}
	
	@Test
	public void testClasses() {
		log.i("----- Test1.testClasses START -----");
		Clazz1 c1 = new Clazz1();
		Clazz2 c2 = new Clazz2();
		log.i("Clazz1.method1 returns int");
		int r1 = c1.method1();
		log.i("Clazz2.method2 returns String");
		String r2 = c2.method2();
		log.i("r1: " + r1);
		log.i("r2: " + r2);
		log.i("----- Test1.testClasses END   -----");
	}
	
	@Test
	public void testClassLength() {
		log.i("----- Test1.testClassLength START -----");
		ClassDefLeng cl = new ClassDefLeng();
		cl.classLength();
		ClassWithLongerNameThanDefault cl2 = new ClassWithLongerNameThanDefault();
		cl2.execute();
		log.i("This one is shorter and filled with spaces...");
		log.i("----- Test1.testClassLength END   -----");
	}
	
}
