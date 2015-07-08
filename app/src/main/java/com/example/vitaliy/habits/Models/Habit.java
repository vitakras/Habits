package com.example.vitaliy.habits.Models;

import com.example.vitaliy.habits.Enums.HabitType;
import com.example.vitaliy.habits.Interfaces.IHabit;

/**
 * Created by Vitaliy on 15-06-15.
 */
public class Habit implements IHabit {

    // Variables
    protected int ID;
    protected String name;
    protected String summary;
    protected HabitType type;
    protected boolean isEnabled;


    public Habit() {
        this.name = new String();
        this.summary = new String();
        this.type = HabitType.DEFAULT;
        this.isEnabled = false;
    }

    public Habit(int ID, String name, String summary, HabitType type) {
        this.ID = ID;
        this.name = name;
        this.summary = summary;
        this.isEnabled = false;
        this.type = type;
    }

    public Habit(int ID, String name, String summary) {
        this.ID = ID;
        this.name = name;
        this.summary = summary;
        this.isEnabled = false;
        this.type = HabitType.DEFAULT;
    }

    public Habit(String name, String summary) {
        this.name = name;
        this.summary = summary;
        this.type = HabitType.DEFAULT;
        this.isEnabled = false;
    }

    public Habit(String name) {
        this.name = name;
        this.summary = new String ();
        this.type = HabitType.DEFAULT;
        this.isEnabled = false;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return this.ID;
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

    @Override
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean getEnabled() {
        return this.isEnabled;
    }

    @Override
    public void setHabitType(HabitType type) {
        this.type = type;
    }

    @Override
    public HabitType getHabitType() {
        return this.type;
    }
}
