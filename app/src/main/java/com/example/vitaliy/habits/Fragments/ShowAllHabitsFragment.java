package com.example.vitaliy.habits.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vitaliy.habits.Adapters.HabitsDrawerAdapter;
import com.example.vitaliy.habits.DB.DatabaseHelper;
import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.R;

import java.util.List;

public class ShowAllHabitsFragment extends Fragment {

    private RecyclerView recyclerView;
    private HabitsDrawerAdapter adapter;

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

        return layout;
    }

    /**
     * Retrives the Habits from the database
     * @return
     */
    public List<IHabit> getData() {
        DatabaseHelper db = new DatabaseHelper(getActivity().getApplicationContext());
        return db.getAllHabits();
    }
}
