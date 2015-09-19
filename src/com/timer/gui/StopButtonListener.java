package com.timer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.timer.i_breaktimer.IStopWatch;

class StopButtonListener implements ActionListener {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(CancelButtonListener.class);

	private final IStopWatch stopWatch;

	public StopButtonListener(IStopWatch stopWatch) {
		this.stopWatch = stopWatch;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (stopWatch.isRunning()) {
			stopWatch.stop();
		}
	}
}
