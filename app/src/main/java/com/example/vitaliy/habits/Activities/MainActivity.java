package com.example.vitaliy.habits.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.FragmentTransaction;
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

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Add the fragment to the 'fragment_container' FrameLayout
            transaction.add(R.id.fragment_container, firstFragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.home:
            case android.R.id.home:
                // Remove Back button

                FragmentManager manager = getFragmentManager();

                if (manager.getBackStackEntryCount() != 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    manager.popBackStack();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAddHabitButtonClicked() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        CreateHabitFragment fragment = new CreateHabitFragment();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container,fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager manager = getFragmentManager();

        if (manager.getBackStackEntryCount() != 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
