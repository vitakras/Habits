package com.example.vitaliy.habits.Interfaces;

/**
 * Created by Vitaliy on 15-06-15.
 */
public interface IDatabaseHabits {

    /**
     * Writes a new habit to the DB
     * @param habit the habit to save to DB
     */
    public void addHabit(IHabit habit);

    /**
     * Updates an existsing habit in the database
     * @param habit the habit to update in the DB
     */
    public void updateHabit(IHabit habit);
}
