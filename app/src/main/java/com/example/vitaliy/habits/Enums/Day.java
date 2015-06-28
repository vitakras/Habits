package com.example.vitaliy.habits.Enums;

/**
 * Created by Vitaliy on 15-06-28.
 */
public enum Day {

    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRDIAY(5), SATURDAY(6);

    int value;

    Day (int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Day getDayByValue(int value) {
        for (Day day : values()) {
            if (value == day.getValue()) return day;
        }

        return null;
    }

}
