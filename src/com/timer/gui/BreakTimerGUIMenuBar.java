package com.timer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

class BreakTimerGUIMenuBar extends JMenuBar{

	//private static final Logger LOG = LoggerFactory.getLogger(BreakTimerGUIMenuBar.class);
	private final JFrame parent;

	public BreakTimerGUIMenuBar(JFrame parent) {
		this.parent = parent;
		initMenu();
	}
	
	
	
	private void initMenu() {
		initFileMenu();
	}

	private void initFileMenu(){
		JMenu fileMenu = new JMenu("File");
		JMenuItem settings = new JMenuItem("Settings");
		settings.addActionListener(new SettingsMenu(parent));
		fileMenu.add(settings);
		this.add(fileMenu);
	}
}

