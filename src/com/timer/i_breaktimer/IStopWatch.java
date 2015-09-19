package com.timer.i_breaktimer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public interface IStopWatch {
	void setMinutes(long minutes);
	void setSeconds(long seconds);
	long getMinutes();
	long getSeconds();
	void start();
	void stop();
	boolean isRunning();
	void removeTimerWatcher(TimerWatcher timerWatcher);
	void addTimerWatcher(TimerWatcher timerWatcher);
}

