package com.timer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.timer.i_breaktimer.IStopWatch;
import com.timer.i_breaktimer.TimerWatcher;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

class StartButtonListener implements ActionListener {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(StartButtonListener.class);

	private final IStopWatch stopWatch;
	private final TimerWatcher watcher;

	public StartButtonListener(IStopWatch stopWatch, TimerWatcher watcher) {
		this.stopWatch = stopWatch;
		this.watcher = watcher;
		this.stopWatch.addTimerWatcher(watcher);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!stopWatch.isRunning()) {
			BreakTimerGUI btg = (BreakTimerGUI) watcher;
			stopWatch.setMinutes(btg.getMinutes());
			stopWatch.setSeconds(btg.getSeconds());
			stopWatch.start();
		}
	}
}
