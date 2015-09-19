package com.timer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.timer.i_breaktimer.IStopWatch;
import com.timer.i_breaktimer.TimerWatcher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

class ResetButtonListener implements ActionListener {

	//private static final Logger LOG = LoggerFactory.getLogger(ResetButtonListener.class);

	private final IStopWatch stopwatch;
	private final TimerWatcher watcher;

	public ResetButtonListener(IStopWatch stopwatch, TimerWatcher watcher) {
		this.stopwatch = stopwatch;
		this.watcher = watcher;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stopwatch.stop();
		watcher.updateMinutes(TimerSettings.getInstance().getMinutes());
		watcher.updateSeconds(TimerSettings.getInstance().getSeconds());
	}
}

