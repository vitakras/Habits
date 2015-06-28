package com.example.vitaliy.habits.Interfaces;

import android.net.Uri;

/**
 * Created by Vitaliy on 15-06-28.
 */
public interface IAlarm {

    /**
     * Set the ID
     * @param id
     */
    public void setID(long id);

    /**
     * Set the time of the hour in the day
     * @param timeHour
     */
    public void getTimeHour (int timeHour);

    /**
     * set the minute of the day
     * @param minute
     */
    public void getTimeMinute (int minute);

    /**
     * Set the Do you want to repeat weekly
     * @param isReapetWeekly
     */
    public void setRepeatWeekly (boolean isReapetWeekly);

    /**
     * Set the is alarm turned on
     * @param isEnabled
     */
    public void setEnabled (boolean isEnabled);

    /**
     * set the tone of the alarm
     * @param tone
     */
    public void setTone (Uri tone);

    /**
     * Get the id
     * @return
     */
    public long getID();

    /**
     * Get the time of hour in the day
     * @return
     */
    public int getTimeHour();

    /**
     * get the minute of the hour
     * @return
     */
    public int getTimeMinute();

    /**
     * is alarm being repeated weekly
     * @return
     */
    public boolean getRepeatWeekly ();

    /**
     * is the alarm enabled
     * @return
     */
    public boolean getEnabled();

}
