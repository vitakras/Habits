package com.example.vitaliy.habits.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vitaliy.habits.Interfaces.IHabit;
import com.example.vitaliy.habits.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vitaliy on 15-06-22.
 */
public class HabitsDrawerAdapter extends RecyclerView.Adapter<HabitsDrawerAdapter.HabitViewHolder> {

    private List<IHabit> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public HabitsDrawerAdapter(Context context, List<IHabit> data) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void detele(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.habit_tile_row,parent,false);
        HabitViewHolder holder = new HabitViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {
        IHabit current = data.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Private class to handle the habit_tile_row.xml
     */
    public class HabitViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView summary;

        public HabitViewHolder(View viewItem) {
            super(viewItem);

            this.name = (TextView) viewItem.findViewById(R.id.habit_name_textView);
            this.name = (TextView) viewItem.findViewById(R.id.habit_summary_textView);
        }
    }
}
