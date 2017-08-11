package it.cri131.sl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.cri131.sl.utils.PropertiesLoader;

public class SlimLogger {

	/* Log Levels */
	public static final int OFF = 0;
	public static final int INFO = 5;
	public static final int DEBUG = 10;
	
	private static SimpleDateFormat sdf;
	private static int logLevel = 1;
	
	public String className;
	private static int classNameChars;
	
	private SlimLogger() {
	}
	
	public static SlimLogger getLogger(Class<?> clazz) {
//		Map<Class<?>, SlimLogger> loggers = SlimLoggersContainer.getLoggers();
//		Set<Class<?>> keys = loggers.keySet();
//		for (Class<?> clazzx : keys) {
//			sysolog(clazzx + ": " + loggers.get(clazzx));
//		}
		
//		sysolog("USO:" + clazz.getName());
		SlimLogger instance = SlimLoggersContainer.getLoggers().get(clazz);
//		sysolog("instance: " + instance);
		if (instance == null) {
			instance = new SlimLogger();
			SlimLogLevel slimLogLevel = null;
			// Set log level
			try {
				slimLogLevel = SlimLogLevel.valueOf(PropertiesLoader.getProperty("slim.logger.level"));
			} catch (IOException e) {
				System.err.println("Cannot find property slim.logger.level");
				e.printStackTrace();
				System.exit(-1);
			}
			// Set date format
			try {
				sdf = new SimpleDateFormat(PropertiesLoader.getProperty("slim.logger.dateformat"));
			} catch (IOException e) {
				System.err.println("Cannot find property slim.logger.dateformat");
				e.printStackTrace();
				System.exit(-1);
			}
			// Set max classname length
			try {
				classNameChars = Integer.parseInt(PropertiesLoader.getProperty("slim.logger.classnamelength"));
			} catch (IOException e) {
				System.err.println("Cannot find property slim.logger.dateformat");
				e.printStackTrace();
				System.exit(-1);
			}
//			sysolog("Setting log level to " + slimLogLevel.getLoglevelName() + "[" + slimLogLevel.getLogLevel() + "]");
			logLevel = slimLogLevel.getLogLevel();
			instance.setClass(clazz);
		}
		SlimLoggersContainer.getLoggers().put(clazz, instance);
		return instance;
	}
	
	// TODO: implementare
	public static SlimLogger getLogger(Class<?> clazz, SlimLogLevel logLevel) {
		return null;
	}
	
	public void write(SlimLogLevel messageLoglevel, Class<?> clazz, String message) {
		int messageLogLevelINT = messageLoglevel.getLogLevel();
		if (messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " (" + messageLoglevel.getLoglevelName() + ") [" + clazz.getName() + "] - " + message);
		}
	}
	
	public void e(String message) {
		int messageLogLevelINT = SlimLogLevel.ERROR.getLogLevel();
		if (messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " (" + SlimLogLevel.ERROR + ") [" + className + "] - " + message);
		}
	}
	
	public void w(String message) {
		int messageLogLevelINT = SlimLogLevel.WARN.getLogLevel();
		if (messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " ( " + SlimLogLevel.WARN + ") [" + className + "] - " + message);
		}
	}
	
	public void i(String message) {
		int messageLogLevelINT = SlimLogLevel.INFO.getLogLevel();
		if (messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " ( " + SlimLogLevel.INFO + ") [" + className + "] - " + message);
		}
	}
	
	public void d(String message) {
		int messageLogLevelINT = SlimLogLevel.DEBUG.getLogLevel();
		if (messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " (" + SlimLogLevel.DEBUG + ") [" + className + "] - " + message);
		}
	}
	
	private void setClass(Class<?> clazz) {
		String clazzName = clazz.getName();
		StringBuilder finalName = new StringBuilder(clazzName);
		if (clazzName.length() > classNameChars) {
//			sysolog("TRIM");
			clazzName = new StringBuilder(finalName.reverse().substring(0, classNameChars)).reverse().toString();
		} else if (clazzName.length() < classNameChars) {
//			sysolog("ADD");
			int missingCharsNumber = classNameChars - clazzName.length();
//			sysolog("Insert " + missingCharsNumber + " spaces at the beginning");
			char[] spaces = new char[missingCharsNumber];
			for (int s = 0; s < spaces.length; s++) {
				spaces[s] = ' ';
			}
			clazzName = finalName.insert(0, spaces).toString();
		} else {
//			sysolog("NOTHING");
		}
//		sysolog(clazzName);
		this.className = clazzName;
	}
	
	@Deprecated
	private static void sysolog(String str) {
		System.out.println("##### " + str);
	}

}
