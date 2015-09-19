package com.timer;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.timer.gui.BreakTimerGUI;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class BreakTimer {

	//private static final Logger LOG = LoggerFactory.getLogger(BreakTimer.class);

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new BreakTimerGUI());
	}
}


