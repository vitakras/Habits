package com.example.vitaliy.habits.Models;

import com.example.vitaliy.habits.Interfaces.IHabit;

/**
 * Created by Vitaliy on 15-06-15.
 */
public class Habit implements IHabit {

    // Variables
    protected String name;
    protected String summary;

    public Habit(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }

    public Habit(String name) {
        this.name = name;
        this.summary = new String ();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSummary() {
        return this.summary;
    }
}