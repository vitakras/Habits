package com.example.vitaliy.habits.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vitaliy.habits.DB.DataBaseHelper;
import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.Models.Habit;
import com.example.vitaliy.habits.R;

import static android.view.View.OnClickListener;


/**
 * A UI for the create of the IHabit interface
 */
public class CreateHabitFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String HABIT_ID = "HABIT_ID";

    private static String CREATE_HABIT_TITLE;
    private static String UPDATE_HABIT_TITLE;


    private static DataBaseHelper db;
    private static IHabit habit;
    private static int id;

    // Required empty public constructor
    public CreateHabitFragment() {}

    /**
     * Creates an Instance of the fragment for creating a new habit
     * @return
     */
    public static CreateHabitFragment newInstance() {
        return new CreateHabitFragment();
    }

    /**
     * Creates an Instance of the fragment for updating an existing habit
     * @param id the ID of the habbit to retrive from DB
     * @return new istance of the CreateHabitFragment fragment
     */
    public static CreateHabitFragment newInstance(int id) {
        CreateHabitFragment fragment = new CreateHabitFragment();
        Bundle args = new Bundle();

        args.putInt(HABIT_ID, id);
        fragment.setArguments(args);

        return fragment;
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DataBaseHelper(getActivity().getApplicationContext());

        setHasOptionsMenu(true);
        // Initilize Titles
        CREATE_HABIT_TITLE = getString(R.string.create_habit_fragment);
        UPDATE_HABIT_TITLE = getString(R.string.update_habit_fragment);

        if (getArguments() != null) {
            id = getArguments().getInt(HABIT_ID);
            habit = db.getHabit(id);
        } else {
            // Reset the habit
            habit = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initilize variables
        View layout = inflater.inflate(R.layout.fragment_create_habit, container, false);
        ActionBarActivity activity = (ActionBarActivity) getActivity();
        Button button = (Button) layout.findViewById(R.id.habit_add_button);

        // Set up Toolbar
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.setTitle(CREATE_HABIT_TITLE);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewHabit();
            }
        });

        // Inflate the layout for this fragment
        return layout;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.create_habit_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.create_habit:
                createNewHabit();
                return true;
            default:
                return getActivity().onOptionsItemSelected(item);
        }
    }

    public void createNewHabit() {
        View view = getView();

        String name = ((EditText) view.findViewById(R.id.habit_name_textfield)).
                getText().toString();
        String summary = ((EditText) view.findViewById(R.id.habit_summary_textfield)).
                getText().toString();

        IHabit habit = new Habit(name,summary);
        db.addHabit(habit);
        db.close();
    }

    public boolean updateHabit() {
        boolean isSuccess = true;

        return true;
    }

}
