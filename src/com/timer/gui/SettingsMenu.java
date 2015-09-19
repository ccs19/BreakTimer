package com.timer.gui;

import com.timer.i_breaktimer.ISettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class SettingsMenu extends JDialog implements ActionListener, ISettings {

    
    private static final String TITLE = "Settings";
    private static final String OKAY_BUTTON_STRING = "OK";
    private static final String CANCLE_BUTTON_STRING = "Cancel";

    private JFrame parent;
    private JTextField secondsField;
    private JTextField minutesField;

    
    SettingsMenu(JFrame parent){
        super();
        this.parent = parent;
        initMenuOptions();
        generateOptions();
    }

    private void finishAndOpenWindow() {
        this.pack();
        this.setLocationRelativeTo(this.parent);
        this.setVisible(true);
        this.setEnabled(true);
    }

    private void generateOptions() {
        GridLayout gl = new GridLayout(2, 2, 10, 10);
        this.setLayout(gl);

        minutesField = new JTextField();
        secondsField = new JTextField();
        JButton okay = generateOkayButton();
        JButton cancel = generateCancelButton();

        this.addComponents(minutesField, secondsField, okay, cancel);
    }

    private JButton generateCancelButton() {
        JButton button = new JButton(CANCLE_BUTTON_STRING);
        button.addActionListener(al -> {});
        return button;
    }

    private JButton generateOkayButton() {
        JButton button = new JButton(OKAY_BUTTON_STRING);
        button.addActionListener(new SavePreferences(this));
        return button;
    }

    private void addComponents(JComponent... jComponents){
        for(JComponent j : jComponents){
            this.add(j);
        }
    }


    private void initMenuOptions(){
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.finishAndOpenWindow();
    }

    @Override
    public long getSeconds() {
        return Long.valueOf(secondsField.getText());
    }

    @Override
    public long getMinutes() {
        return Long.valueOf(minutesField.getText());
    }
}
