package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class TaskAdder extends AppCompatActivity {
    TasksDAO tasksDAO;
    Button addTaskButton;
    EditText titleTV,descriptionTV, deadlineTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adder);

        addTaskButton = findViewById(R.id.button_add_task);
        titleTV = findViewById(R.id.title);
        descriptionTV = findViewById(R.id.description);
        deadlineTV = findViewById(R.id.deadline);
        tasksDAO = new TasksDAO(this);


        addTaskButton.setOnClickListener(v -> {
            Task task = new Task(titleTV.getText().toString(),descriptionTV.getText().toString(), null, false);
            tasksDAO.addTask(task);
            Toast.makeText(getApplicationContext(), "Added new task", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(TaskAdder.this, MainActivity.class));
        });
    }
}