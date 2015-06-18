package com.example.vitaliy.habits.Interfaces;

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
}
