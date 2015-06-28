package com.example.vitaliy.habits.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vitaliy.habits.Fragments.CreateHabitFragment;
import com.example.vitaliy.habits.Fragments.ShowAllHabitsFragment;
import com.example.vitaliy.habits.R;

public class MainActivity extends ActionBarActivity implements ShowAllHabitsFragment.OnAllHabitsListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // Make sure fragment container exists
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create new fragment to be placed in the activity
            //CreateHabitFragment firstFragment = new CreateHabitFragment();
            ShowAllHabitsFragment firstFragment = new ShowAllHabitsFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Add the fragment to the 'fragment_container' FrameLayout
            transaction.add(R.id.fragment_container, firstFragment);
            transaction.commit();
        }
    }

    @Override
    protected void onResume() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case android.R.id.home:
                FragmentManager transaction = getFragmentManager();

                if (transaction.getBackStackEntryCount() != 0) {
                    transaction.popBackStack();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAddHabitButtonClicked() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        CreateHabitFragment fragment = new CreateHabitFragment();

        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
