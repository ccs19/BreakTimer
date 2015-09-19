package com.timer.breaktimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.timer.i_breaktimer.TimerObservable;
import com.timer.i_breaktimer.TimerObserver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class CountdownTimer extends TimerTask implements TimerObservable{

	//private static final Logger LOG = LoggerFactory.getLogger(CountdownTimer.class);

	private Timer timer;
	private long minutes = 0;
	private long totalSeconds;
	private static final long ONE_SECOND = 1000L;
	private final List<TimerObserver> observers;
	private boolean finished = false;
	
	public CountdownTimer(long seconds) {
		this();
		totalSeconds = seconds;
		startTimer();
	}
	
	public CountdownTimer(long seconds, long minutes){
		this();
		totalSeconds = seconds + minutes * 60L;
		this.minutes = minutes;
		startTimer();
	}
	
	private CountdownTimer() {
		observers = new ArrayList<>();
	}

	private void startTimer(){
		timer = new Timer();
		timer.schedule(this, ONE_SECOND, ONE_SECOND);
		System.out.printf("Starting timer at %d seconds\n", totalSeconds);
	}
	


	@Override
	public void run() {
		checkTimerExpired();
		//updateConsole();
	}

	private void checkTimerExpired() {
		if(totalSeconds <= 0 && minutes == 0){
			finished = true;
			this.cancel();
		}else if(secondsRemaining() == 0 && minutes > 0){
			minutes--;
		}
		totalSeconds--;
		notifyObservers();
	}

	@SuppressWarnings("unused")
	private void updateConsole() {
		if(minutes != 0){
			System.out.printf("%dm %ds remaining\n", minutes, secondsRemaining());
		}else{
			System.out.printf("%ds remaining\n", secondsRemaining());
		}
	}
	
	public long secondsRemaining(){
		return (totalSeconds) % 60;
	}

	@Override
	public long minutesRemaining() {
		return minutes;
	}

	@Override
	public long totalSecondsRemaining() {
		return totalSeconds;
	}

	@Override
	public void notifyObservers() {
		for(TimerObserver ob : observers){
			ob.notifyObserver(this);
		}
	}

	@Override
	public void addObserver(TimerObserver timerObserver) {
		if(!observers.contains(timerObserver)){
			observers.add(timerObserver);
		}
	}

	@Override
	public void removeObserver(TimerObserver timerObserver) {
		observers.remove(timerObserver);
	}

	@Override
	public void cancelTimer() {
		this.cancel();
	}

	@Override
	public boolean isFinished() {
		return finished;
	}
}

