package com.example.vitaliy.habits.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vitaliy.habits.DB.DatabaseHelper;
import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.Models.Habit;
import com.example.vitaliy.habits.R;

import static android.view.View.*;


/**
 * A UI for the create of the IHabit interface
 */
public class CreateHabitFragment extends Fragment {

    private DatabaseHelper db;
    private Button button;

    // Required empty public constructor
    public CreateHabitFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getActivity().getApplicationContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_create_habit, container, false);
        Button button = (Button) layout.findViewById(R.id.habit_add_button);

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void createNewHabit() {
        View view = getView();

        String name = ((EditText) view.findViewById(R.id.habit_name_textfield)).
                getText().toString();
        String summary = ((EditText) view.findViewById(R.id.habit_summary_textfield)).
                getText().toString();

        IHabit habit = new Habit(name,summary);
        db.addHabit(habit);
    }

}
