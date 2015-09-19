package com.timer.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import com.timer.breaktimer.StopWatch;
import com.timer.i_breaktimer.IStopWatch;
import com.timer.i_breaktimer.TimerWatcher;
 

public class BreakTimerGUI implements TimerWatcher{
	
	private static final int OUTER_TIME_SPACING = 10;
	private static final int OUTER_BUTTON_SPACING = 10;
	private static final int MIDDLE_BUTTON_SPACING = 30;
	private JFrame timerFrame;
	private JPanel timerPanel;
	private JButton startButton;
	private JButton stopButton;
	private JFormattedTextField minutesField;
	private JFormattedTextField secondsField;
	private IStopWatch stopWatch = null;
	private JButton resetButton;
	
	private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder();
	private static final String TITLE = "Break Timer";
	private static final String START_TEXT = "Start";
	private static final String STOP_TEXT = "Stop";
	private static final String DEFAULT_MINUTE = "00";
	private static final String DEFAULT_SECOND = "10";
	private static final String RESET_TEXT = "Reset";
	
	
	public BreakTimerGUI(){
		setLookAndFeel();
		initComponents();
		finishSetup();
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} 
		catch (Exception ex){}
		
	}

	private void finishSetup() {
		timerFrame.pack();
		timerFrame.setVisible(true);
		timerPanel.setVisible(true);
		timerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void initComponents() {
		timerFrame = new JFrame(TITLE);
		initPanel();
		timerPanel.add(createInputFields());
		timerPanel.add(createButtons());
		//addComponents();
		timerFrame.add(timerPanel);
		timerFrame.setJMenuBar(new BreakTimerGUIMenuBar(timerFrame));
	}

	private void initPanel() {
		timerPanel = new JPanel();
		timerPanel.setLayout(new GridLayout(2, 1));
		
	}

	private JPanel createInputFields() {
		JPanel panel = new JPanel(new GridBagLayout());
		
		JTextField colon = new JTextField(":");
		Font textFieldFont = new Font("SansSerif",Font.BOLD, 30);
		
		try {
			minutesField = new JFormattedTextField(new MaskFormatter("##"));
			secondsField = new JFormattedTextField(new MaskFormatter("##"));
		} catch (ParseException e) {e.printStackTrace();}
		
		minutesField.setBorder(EMPTY_BORDER);
		secondsField.setBorder(EMPTY_BORDER);
		colon.setBorder(EMPTY_BORDER);
		
		minutesField.setBackground(timerPanel.getBackground());
		secondsField.setBackground(timerPanel.getBackground());
		colon.setBackground(timerPanel.getBackground());
		
		minutesField.setColumns(2);
		secondsField.setColumns(2);
		colon.setColumns(1);
		
		minutesField.setText(DEFAULT_MINUTE);
		secondsField.setText(DEFAULT_SECOND);
		
		minutesField.setFont(textFieldFont);
		secondsField.setFont(textFieldFont);
		colon.setFont(textFieldFont);
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.gridx++;
		panel.add(Box.createRigidArea(new Dimension(OUTER_TIME_SPACING,OUTER_TIME_SPACING)));
		
		gbc.gridx++;
		panel.add(minutesField, gbc);
		
		gbc.gridx++;
		panel.add(colon, gbc);
		
		gbc.gridx++;
		panel.add(secondsField, gbc);
		
		gbc.gridx++;
		panel.add(Box.createRigidArea(new Dimension(OUTER_TIME_SPACING,OUTER_TIME_SPACING)));
		return panel;
	}
	


	private JPanel createButtons() {
		JPanel panel = new JPanel(new GridBagLayout());
		startButton = new JButton(START_TEXT);
		stopButton = new JButton(STOP_TEXT);
		resetButton = new JButton(RESET_TEXT);
		stopWatch = new StopWatch();
		startButton.addActionListener(new StartButtonListener(stopWatch, this));
		stopButton.addActionListener(new StopButtonListener(stopWatch));
		resetButton.addActionListener(new ResetButtonListener(stopWatch, this));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx= 0;
		gbc.gridx++;
		gbc.gridy = 0;
		
		panel.add(Box.createRigidArea(new Dimension(OUTER_BUTTON_SPACING,OUTER_BUTTON_SPACING)), gbc);
		
		gbc.gridx++;
		panel.add(startButton, gbc);
		
		gbc.gridx++;
		panel.add(Box.createRigidArea(new Dimension(MIDDLE_BUTTON_SPACING,MIDDLE_BUTTON_SPACING)), gbc);
		
		gbc.gridx++;
		panel.add(stopButton, gbc);
		
		gbc.gridx++;
		panel.add(Box.createRigidArea(new Dimension(MIDDLE_BUTTON_SPACING,MIDDLE_BUTTON_SPACING)), gbc);
		
		gbc.gridx++;
		panel.add(resetButton, gbc);
		
		gbc.gridx++;
		panel.add(Box.createRigidArea(new Dimension(OUTER_BUTTON_SPACING,OUTER_BUTTON_SPACING)), gbc);
		
		return panel;
	}

	private void addComponents() {
		addComponentsToPanel();
	}
	
	
	private void addComponentsToPanel() {
		timerPanel.add(minutesField);
		timerPanel.add(secondsField);
		timerPanel.add(startButton);
		timerPanel.add(stopButton);
	}
	
	public long getMinutes(){
		return Long.valueOf(minutesField.getText());
	}
	
	public long getSeconds(){
		return Long.valueOf(secondsField.getText());
	}

	@Override
	public void updateSeconds(long seconds) {
		String sec = String.format("%02d", seconds);
		secondsField.setText(sec);
	}

	@Override
	public void updateMinutes(long minutes) {
		String min = String.format("%02d", minutes);
		minutesField.setText(min);
	}

	@Override
	public void complete() {
		ShowNotification.showBreakNotification(timerFrame);
	}
}