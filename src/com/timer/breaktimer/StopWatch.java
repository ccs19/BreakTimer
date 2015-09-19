package com.timer.breaktimer;

import java.util.ArrayList;
import java.util.List;

import com.timer.i_breaktimer.IStopWatch;
import com.timer.i_breaktimer.TimerObservable;
import com.timer.i_breaktimer.TimerObserver;
import com.timer.i_breaktimer.TimerWatcher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class StopWatch implements TimerObserver, IStopWatch {

	private TimerObservable timerObservable;
	private long seconds;
	private long minutes;
	private final List<TimerWatcher> timerWatchers;
	private boolean running = false;

	public StopWatch() {
		timerWatchers = new ArrayList<>();
	}

	@Override
	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	@Override
	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	@Override
	public long getMinutes() {
		return minutes;
	}

	@Override
	public long getSeconds() {
		return seconds;
	}

	@Override
	public void start() {
		timerObservable = new CountdownTimer(getSeconds(), getMinutes());
		timerObservable.addObserver(this);
		running = true;
	}

	@Override
	public void stop() {
		if (running) {
			timerObservable.cancelTimer();
			running = false;
		}
	}

	@Override
	public void notifyObserver(TimerObservable timerObservable) {
		setMinutes(timerObservable.minutesRemaining());
		setSeconds(timerObservable.secondsRemaining());
		updateWatchers();
		if (timerObservable.isFinished()) {
			notifyWatchers();
		}
	}

	private void updateWatchers() {
		for (TimerWatcher t : timerWatchers) {
			t.updateSeconds(getSeconds());
			t.updateMinutes(getMinutes());
		}
	}

	private void notifyWatchers() {
		for (TimerWatcher t : timerWatchers) {
			t.complete();
		}
		this.stop();
	}

	@Override
	public void addTimerWatcher(TimerWatcher timerWatcher) {
		if (!timerWatchers.contains(timerWatcher)) {
			timerWatchers.add(timerWatcher);
		}
	}

	@Override
	public void removeTimerWatcher(TimerWatcher timerWatcher) {
		timerWatchers.remove(timerWatcher);
	}

	@Override
	public boolean isRunning() {
		return running;
	}

}
