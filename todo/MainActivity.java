package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button button_add;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button_add = findViewById(R.id.button_addTask);

        button_add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskAdder.class);
            startActivities(intent);
        });
    }
}