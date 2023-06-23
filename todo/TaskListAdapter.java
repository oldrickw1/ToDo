package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TaskListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Task> tasks;
    LayoutInflater inflater;

    public TaskListAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
            return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView titleTV = (TextView) view.findViewById(R.id.title_listItem);
        titleTV.setText(tasks.get(i).getTitle());
        TextView descriptionTV = (TextView) view.findViewById(R.id.description_listItem);
        descriptionTV.setText(tasks.get(i).getDescription());
        TextView deadlineTV = (TextView) view.findViewById(R.id.deadline_listItem);
        if (tasks.get(i).getDeadline()!=null) {
            deadlineTV.setText(tasks.get(i).getDeadline().toString());
        } else {
            deadlineTV.setText("No Deadline");
        }
        TextView completedTV = (TextView) view.findViewById(R.id.completed_listItem);
        completedTV.setText(tasks.get(i).isCompleted()?"Yes":"No");
        return view;
    }
}
