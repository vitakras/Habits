package com.example.vitaliy.habits.Models;

import android.net.Uri;

import com.example.vitaliy.habits.Enums.Day;
import com.example.vitaliy.habits.Interfaces.IAlarm;

/**
 * Created by Vitaliy on 15-06-28.
 */
public class Alarm implements IAlarm{

    // Properties
    protected long id;
    protected int timeHour, timeMinute;
    protected boolean isRepeatWeekly, isEnabed;
    protected boolean [] repeatingDays;
    protected Uri tone;

    public Alarm() {
        this.repeatingDays = new boolean[7];
    }

    public Alarm(int timeHour, int timeMinute) {
        this.repeatingDays = new boolean[7];
        this.timeHour = timeHour;
        this.timeMinute = timeMinute;
    }

    public Alarm(int timeHour, int timeMinute, boolean isRepeatWeekly) {
        this.repeatingDays = new boolean[7];
        this.timeHour = timeHour;
        this.timeMinute = timeMinute;
        this.isRepeatWeekly = isRepeatWeekly;
    }

    public Alarm(int timeHour, int timeMinute, boolean isRepeatWeekly, boolean isEnabed) {
        this.repeatingDays = new boolean[7];
        this.timeHour = timeHour;
        this.timeMinute = timeMinute;
        this.isRepeatWeekly = isRepeatWeekly;
        this.isEnabed = isEnabed;
    }

    @Override
    public void setRepeatingDay(Day day, boolean value) {
        this.repeatingDays[day.getValue()] = value;
    }

    @Override
    public boolean getReapetingDay(Day day) {
        return this.repeatingDays[day.getValue()];
    }

    @Override
    public void setID(long id) {
        this.id = id;
    }

    @Override
    public void getTimeHour(int timeHour) {
        this.timeHour = timeHour;
    }

    @Override
    public void getTimeMinute(int minute) {
        this.timeMinute = minute;
    }

    @Override
    public void setRepeatWeekly(boolean isReapetWeekly) {
        this.isRepeatWeekly = isReapetWeekly;
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        this.isEnabed = isEnabled;
    }

    @Override
    public void setTone(Uri tone) {
        this.tone = tone;
    }

    @Override
    public long getID() {
        return this.id;
    }

    @Override
    public int getTimeHour() {
        return this.timeHour;
    }

    @Override
    public int getTimeMinute() {
        return this.timeMinute;
    }

    @Override
    public boolean getRepeatWeekly() {
        return this.isRepeatWeekly;
    }

    @Override
    public boolean getEnabled() {
        return this.isEnabed;
    }
}
