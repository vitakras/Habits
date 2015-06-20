package com.example.vitaliy.habits.Interfaces;

import java.util.List;

/**
 * Created by Vitaliy on 15-06-15.
 */
public interface IDatabaseHabits {

    /**
     * Add a new habit into the db
     * @param habit habit to add
     * @return id of the new habit
     */
    public long addHabit(IHabit habit);

    /**
     * update an existing habit in the db
     * @param habit habit to update
     * @return id of the updated habit
     */
    public long updateHabit(IHabit habit);

    /**
     * Returns the habit based on its ID
     * @param id the id of the habit
     * @return Habit
     */
    public IHabit getHabit(int id);

    /**
     * Returns a List of all the habbits in the db
     * @return
     */
    public List<IHabit> getAllHabits();

    /**
     * Deletes a habit from the db
     * @param id of the habit you are trying to delete
     * @return id of the deleted habit
     */
    public int deleteHabit(int id);

}
