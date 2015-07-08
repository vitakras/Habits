package com.example.vitaliy.habits.Interfaces;

import com.example.vitaliy.habits.Enums.HabitType;

/**
 * Created by Vitaliy on 15-06-15.
 */
public interface IHabit {

    /**
     * ID of the habit
     * @param ID
     */
    public void setID(int ID);

    /**
     * ID of the habit
     * @return
     */
    public int getID();

    /**
     * Set the name of the habit
     * @param name of the habit
     */
    public void setName(String name);

    /**
     * Description of the habit
     * @param summary description of the summary
     */
    public void setSummary(String summary);

    /**
     * Name of the Habit
     * @return get name of the habit
     */
    public String getName ();

    /**
     * Summary of the Habit
     * @return get summary of the habit
     */
    public String getSummary();

    /**
     * Set if the habit is currently enabled or not
     * @param isEnabled
     */
    public void setEnabled(boolean isEnabled);

    /**
     * Return if the habit is currently enabled or not
     * @return
     */
    public boolean getEnabled();

    /**
     * Sets the type of the habit
     * @param type
     */
    public void setHabitType(HabitType type);

    /**
     * Returns the type of habit
     * @return
     */
    public HabitType getHabitType();
}
