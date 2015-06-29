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

    public static abstract class AlarmColumns implements BaseColumns {
        public static final String TABLE_NAME = "alarm";
        public static final String COLUMN_HOUR = "hour";
        public static final String COLUMN_MINUTE = "minute";
        public static final String COLUMN_REPEAT_WEEKLY = "repeatWeekly";
        public static final String COLUMN_ENABLED = "enabled";
        public static final String COLUMN_TONE = "tone";
    }

    public static abstract class RepeatingDayColumns implements BaseColumns {
        public static final String TABLE_NAME = "repeatingDay";
        public static final String COLUMN_ALARM_ID = "alarmID";
        public static final String COLUMN_DAY = "day";
    }
}
