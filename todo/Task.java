package com.example.todo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean isCompleted;

    public Task(String title, String description, LocalDateTime date, boolean completed) {
        setTitle(title);
        setDescription(description);
        setDeadline(date);
        setCompleted(completed);
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim().toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim().toLowerCase();
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }
}
