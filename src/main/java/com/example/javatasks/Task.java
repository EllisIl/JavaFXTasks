package com.example.javatasks;

public class Task {
    private String title;
    private String description;
    private String category;
    public boolean isComplete;

    public Task(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.isComplete = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return title + " - " + (isComplete ? "Complete" : "Incomplete");
    }
}
