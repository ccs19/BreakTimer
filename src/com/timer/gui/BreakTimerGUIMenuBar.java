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
		settings.addActionListener(new SettingsMenu());
		fileMenu.add(settings);
		this.add(fileMenu);
	}
	
	private class SettingsMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			openSettingsPane();
		}

		private void openSettingsPane() {
			JOptionPane pane = new JOptionPane();
			JDialog dialog = pane.createDialog("Settings");
			JTextField minutes = new JTextField("Minutes");
			JTextField seconds = new JTextField("Seconds");
			JButton okayButton = new JButton("OK");
			JButton cancelButton = new JButton("Cancel");
			
			JPanel panel = new JPanel();
			panel.add(minutes);
			panel.add(seconds);
			panel.add(okayButton);
			panel.add(cancelButton);
			dialog.add(panel);
			dialog.setVisible(true);
		}
		
	}
}

