package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Objects;

public class TasksDAO extends SQLiteOpenHelper {
    private final String TABLE_NAME = "tasks";
    private final String TITLE_COLUMN = "title";
    private final String DESCRIPTION_COLUMN = "description";
    private final String DEADLINE_COLUMN = "deadline";
    private final String COMPLETED_COLUMN = "completed";
    public TasksDAO(Context context) {
        super(context, "tasks.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT , title TEXT, description INTEGER, deadline INTEGER, completed INTEGER)";
        db.execSQL(createTableStatement);
    }

    public void addTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE_COLUMN, task.getTitle());
        values.put(DESCRIPTION_COLUMN, task.getDescription());
        if (task.getDeadline() != null) {
            values.put(DEADLINE_COLUMN, task.getDeadline().toEpochSecond(ZoneOffset.UTC));
        }
        values.put(COMPLETED_COLUMN, task.isCompleted() ? 1 : 0);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM '" + TABLE_NAME + "';", null);

        while (cs.moveToNext()) {
            String title = cs.getString(1);
            String description = cs.getString(2);
//            LocalDateTime deadline = LocalDateTime.ofInstant(Instant.ofEpochSecond(cs.getInt(3)), ZoneId.systemDefault());
            boolean isCompleted = cs.getInt(4) == 1;
            tasks.add(new Task(title, description, null, isCompleted));
        }
        cs.close();
        db.close();
        return tasks;
    }
}
