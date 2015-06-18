package com.example.vitaliy.habits.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.Interfaces.IDatabaseHabits;

/**
 * Created by Vitaliy on 15-06-17.
 */
public class DatabaseHelper extends SQLiteOpenHelper implements IDatabaseHabits {

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "COM.VK.HABITS";

    // Table Names
    private static final String TABLE_HABIT = "habits";

    // Common column names
    private static final String KEY_ID = "id";

    // Habits Table - column names
    private static final String KEY_NAME = "name";
    private static final String KEY_SUMMARY = "summary";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_HABIT = "CREATE TABLE "
            + TABLE_HABIT + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT," + KEY_SUMMARY + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HABIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop older table if exsits
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HABIT);

        // create new table
        onCreate(db);
    }

    @Override
    public void addHabit(IHabit habit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, habit.getName());
        values.put(KEY_SUMMARY, habit.getSummary());

        // add to table and close
        db.insert(TABLE_HABIT, null, values);
    }

    @Override
    public void updateHabit(IHabit habit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, habit.getName());
        values.put(KEY_SUMMARY, habit.getSummary());

        db.update(TABLE_HABIT,values, KEY_ID + " = ?",
                new String[] { String.valueOf(habit.getID()) });
    }

    /**
     * Close database
     */
    public void close() {
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen()) {
            db.close();
        }
    }
}
