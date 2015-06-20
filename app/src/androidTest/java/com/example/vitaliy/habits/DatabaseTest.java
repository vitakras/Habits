package com.example.vitaliy.habits;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import com.example.vitaliy.habits.DB.DatabaseHelper;
import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.Models.Habit;

/**
 * Created by Vitaliy on 15-06-17.
 */
public class DatabaseTest extends AndroidTestCase {
    private DatabaseHelper db;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        db = new DatabaseHelper(context);
    }

    @Override
    protected void tearDown() throws Exception {
        db.close();
        super.tearDown();
    }

    public void testAddHabit() {
        IHabit model = getModel();

        int id = (int) db.addHabit(model);

        IHabit returnedModel = db.getHabit(id);

        assertEquals(model.getName(),returnedModel.getName());
        assertEquals(model.getSummary(),returnedModel.getSummary());
    }


    /**
     * Returns a test model
     * @return
     */
    private IHabit getModel() {
        String name = "Habit 1";
        String summary = "Habit 1 summary test";

        return new Habit(name,summary);
    }
 }
