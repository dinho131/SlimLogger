package it.cri131.sl.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoader {
	
	private static PropertiesLoader instance;
	
	private static Properties prop;
	
	private PropertiesLoader() throws IOException {
		prop = new Properties();
		String current = new java.io.File( "." ).getCanonicalPath();
		String nnmPurgeConf = current + File.separator + "sl.properties";
		System.out.println(nnmPurgeConf);
		InputStream resourceStream = null;
		try {
			resourceStream = new FileInputStream(nnmPurgeConf);
		} catch(FileNotFoundException ex) { 
			System.out.println("Loading default configuration");
			resourceStream = ClassLoader.getSystemResourceAsStream("sl.properties");
		} finally {
			prop.load(resourceStream);
			resourceStream.close();
		}
		
	}
	
	public static String getProperty(String property) throws IOException {
		if(instance == null) {
			instance = new PropertiesLoader();
			System.out.println("--- LOAD PROPERTIES ---");
		}
		return prop.getProperty(property);
	}
	
	public static void listProperties() throws IOException {
		Set<Object> keys = prop.keySet();
		for(Object key : keys) {
			System.out.println(key + "=" + prop.getProperty((String)key));
		}
	}
	
}
