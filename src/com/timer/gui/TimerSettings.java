package com.timer.gui;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class TimerSettings {

	//private static final Logger LOG = LoggerFactory.getLogger(TimerSettings.class);
	
	private long seconds = 0;
	private long minutes = 30;
	private static TimerSettings instance;

	private TimerSettings() {
	}
	
	public static TimerSettings getInstance(){
		if(instance == null){
			instance = new TimerSettings();
		}
		return instance;
	}
	
	public long getSeconds(){
		return seconds;
	}
	
	public long getMinutes(){
		return minutes;
	}
}

