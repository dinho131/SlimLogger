package it.cri131.sl;

public enum SlimLogLevel {

	OFF		("  OFF", 0),
	ERROR	("ERROR", 2),
	WARN	(" WARN", 3),
	INFO	(" INFO", 5),
	DEBUG	("DEBUG", 7);

	private String logLevelName;
	private int logLevel;

	public String getLoglevelName() {
		return logLevelName;
	}

	public int getLogLevel() {
		return logLevel;
	}

	private SlimLogLevel(String loglevelName, int loglevel) {
		this.logLevelName = loglevelName;
		this.logLevel = loglevel;
	}

}