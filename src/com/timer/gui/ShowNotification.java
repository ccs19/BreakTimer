package com.timer.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class ShowNotification {

	public static void showBreakNotification(final JFrame parent) {
		java.awt.EventQueue.invokeLater(() -> {
            parent.setLocationRelativeTo(null);
            parent.setAlwaysOnTop(true);
            parent.toFront();
            parent.repaint();
            JOptionPane.showMessageDialog(parent, "Time for a break",
                    "Take a break!", JOptionPane.INFORMATION_MESSAGE);
            parent.setAlwaysOnTop(false);
        });
	}

	private static GraphicsDevice getDisplay() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
	}
}
