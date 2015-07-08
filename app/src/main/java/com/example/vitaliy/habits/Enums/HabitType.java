package com.example.vitaliy.habits.Enums;

/**
 * Created by Vitaliy on 15-06-28.
 */
public enum HabitType {
    DEFAULT("DEFAULT"),
    HABIT_ALARM("HABIT_ALARM");

    String type;

    HabitType (String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }

    public HabitType getHabitByName (String name) {
        for (HabitType type : values()) {
            if (type.getValue().equals(name)) {
                return type;
            }
        }

        return null;
    }

}
