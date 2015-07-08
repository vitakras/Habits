package com.example.vitaliy.habits.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.Interfaces.IDataBaseHabits;
import com.example.vitaliy.habits.Models.Habit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 15-06-17.
 */
public class DataBaseHelper extends SQLiteOpenHelper implements IDataBaseHabits {


    // Logcat tag
    private static final String LOG = DataBaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "COM.VK.HABITS";

    // Table Create Statements
    private static final String CREATE_TABLE_HABIT = "CREATE TABLE "
            + HabitsContract.HabitColumns.TABLE_NAME + "("
            + HabitsContract.HabitColumns._ID + " INTEGER PRIMARY KEY,"
            + HabitsContract.HabitColumns.COLUMN_NAME_NAME + " TEXT,"
            + HabitsContract.HabitColumns.COLUMN_NAME_SUMMARY + " TEXT)";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HABIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop older table if exsits
        db.execSQL("DROP TABLE IF EXISTS " + HabitsContract.HabitColumns.TABLE_NAME);

        // create new table
        onCreate(db);
    }

    @Override
    public long addHabit(IHabit habit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitsContract.HabitColumns.COLUMN_NAME_NAME, habit.getName());
        values.put(HabitsContract.HabitColumns.COLUMN_NAME_SUMMARY, habit.getSummary());

        // add to table and close
        return db.insert(HabitsContract.HabitColumns.TABLE_NAME, null, values);
    }

    @Override
    public IHabit getHabit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + HabitsContract.HabitColumns.TABLE_NAME
                + " WHERE " + HabitsContract.HabitColumns._ID + " = " + id;

        Cursor cursor =  db.rawQuery(query, null);

        if (cursor.moveToNext()) {
            return populateHabitModel(cursor);
        }

        return null;
    }

    @Override
    public List<IHabit> getAllHabits() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + HabitsContract.HabitColumns.TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);
        List<IHabit> habits = new ArrayList<>();

        while (cursor.moveToNext()) {
             habits.add(populateHabitModel(cursor));
        }

        return habits;
    }

    @Override
    public int deleteHabit(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(HabitsContract.HabitColumns.TABLE_NAME,
                HabitsContract.HabitColumns._ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    @Override
    public long updateHabit(IHabit habit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitsContract.HabitColumns.COLUMN_NAME_NAME, habit.getName());
        values.put(HabitsContract.HabitColumns.COLUMN_NAME_SUMMARY, habit.getSummary());

       return  db.update(HabitsContract.HabitColumns.TABLE_NAME,
               values, HabitsContract.HabitColumns._ID + " = ?",
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

    /**
     * Converts a column query into IHabit
     * @param cursor the query
     * @return
     */
    private IHabit populateHabitModel(Cursor cursor) {
        IHabit habit = new Habit();

        habit.setID(cursor.getInt(cursor.getColumnIndex(HabitsContract.HabitColumns._ID)));
        habit.setName(cursor.getString(cursor.getColumnIndex(HabitsContract.HabitColumns.COLUMN_NAME_NAME)));
        habit.setSummary(cursor.getString(cursor.getColumnIndex(HabitsContract.HabitColumns.COLUMN_NAME_SUMMARY)));

        return habit;
    }
}
