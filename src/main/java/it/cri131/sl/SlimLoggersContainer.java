package it.cri131.sl;

import java.util.HashMap;
import java.util.Map;

public abstract class SlimLoggersContainer {

	private static Map<Class<?>, SlimLogger> loggers = new HashMap<Class<?>, SlimLogger>();

	public static Map<Class<?>, SlimLogger> getLoggers() {
		return loggers;
	}

	public static void setLoggers(Map<Class<?>, SlimLogger> loggers) {
		SlimLoggersContainer.loggers = loggers;
	}

}
