package com.example.vitaliy.habits.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.vitaliy.habits.Adapters.HabitsDrawerAdapter;
import com.example.vitaliy.habits.DB.DataBaseHelper;
import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.R;

import java.util.List;

public class ShowAllHabitsFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;

    private HabitsDrawerAdapter adapter;
    private OnAllHabitsListener listener;

    // Required empty public constructor
    public ShowAllHabitsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout =  inflater.inflate(R.layout.fragment_show_all_habits, container, false);
        this.recyclerView = (RecyclerView) layout.findViewById(R.id.drawerHabitList);
        this.adapter = new HabitsDrawerAdapter(getActivity(),getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ImageButton button = (ImageButton) layout.findViewById(R.id.new_habit_fab);
        button.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            listener = (OnAllHabitsListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_habit_fab:
                listener.onAddHabitButtonClicked();
                break;
            default:
                break;
        }
    }

    /**
     * Retrives the Habits from the database
     * @return
     */
    public List<IHabit> getData() {
        DataBaseHelper db = new DataBaseHelper(getActivity().getApplicationContext());
        return db.getAllHabits();
    }


    /**
     * Interface for changing the fragment for another
     */
    public interface OnAllHabitsListener {
        public void onAddHabitButtonClicked();
    }
}
