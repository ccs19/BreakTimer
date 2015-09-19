package com.timer.gui;

import com.timer.i_breaktimer.ISavePreferences;
import com.timer.i_breaktimer.ISettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by chris_000 on 9/18/2015.
 */
class SavePreferences implements ISavePreferences, ActionListener {

    private ISettings settings;

    SavePreferences(ISettings settings){
        this.settings = settings;
    }

    @Override
    public void save(Map<String, String> prefs) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //save();
    }
}
