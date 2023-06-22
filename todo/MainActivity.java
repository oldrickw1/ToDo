package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button newTaskButton;
    ListView tasksLV;
    TasksDAO tasksDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksLV = findViewById(R.id.listView);
        newTaskButton = findViewById(R.id.button_new_task);
        tasksDAO = new TasksDAO(this);

        listAllTasks();

        newTaskButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskAdder.class);
            startActivity(intent);
        });
    }

    private void listAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

    }
}