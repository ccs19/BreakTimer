package com.timer.i_breaktimer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public interface TimerObservable {
	long secondsRemaining();
	long minutesRemaining();
	long totalSecondsRemaining();
	void notifyObservers();
	void addObserver(TimerObserver timerObserver);
	void removeObserver(TimerObserver timerObserver);
	void cancelTimer();
	boolean isFinished();
}

