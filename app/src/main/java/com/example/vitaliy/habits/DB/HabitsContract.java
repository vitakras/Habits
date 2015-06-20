package com.example.vitaliy.habits.DB;

import android.provider.BaseColumns;

/**
 * Created by Vitaliy on 15-06-20.
 */
public final class HabitsContract {

    public HabitsContract() {}

    public static abstract class HabitColumns implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_SUMMARY = "summary";
    }
}
