package com.timer.breaktimer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by chris_000 on 9/18/2015.
 */
@XmlRootElement
public class TimerPreferences {

    private static final long DEFAULT_SECONDS = 0;
    private static final long DEFAULT_MINUTES = 0;




    @XmlElement
    private long seconds = DEFAULT_SECONDS;
    @XmlElement
    private long minutes = DEFAULT_MINUTES;

    public TimerPreferences(){}

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

}
