package com.example.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.ZoneOffset;

public class TasksDAO extends SQLiteOpenHelper {
    final String TABLE_NAME = "tasks";
    final String TITLE_COLUMN = "title";
    final String DESCRIPTION_COLUMN = "description";
    final String DEADLINE_COLUMN = "deadline";
    final String COMPLETED_COLUMN = "completed";
    public TasksDAO(Context context) {
        super(context, "tasks.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT , title TEXT, description TEXT, deadline INT, completed BOOLEAN)";
        db.execSQL(createTableStatement);
    }

    public void addTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE_COLUMN, task.getTitle());
        values.put(DESCRIPTION_COLUMN, task.getDescription());
        values.put(DEADLINE_COLUMN, task.getDeadline().toEpochSecond(ZoneOffset.UTC));
        values.put(DESCRIPTION_COLUMN, task.getDescription());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
