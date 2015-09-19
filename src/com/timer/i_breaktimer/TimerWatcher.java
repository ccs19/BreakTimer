package com.timer.i_breaktimer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public interface TimerWatcher {
	void updateSeconds(long seconds);
	void updateMinutes(long minutes);
	void complete();
}

