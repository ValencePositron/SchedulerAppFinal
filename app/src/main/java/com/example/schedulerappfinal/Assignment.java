package com.example.schedulerappfinal;

import java.util.Date;

public class Assignment {
    private String title;
    private String dueDate;
    private String associatedClass;

    public Assignment(String title, String dueDate, String associatedClass) {
        this.title = title;
        this.dueDate = dueDate;
        this.associatedClass = associatedClass;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssociatedClass() {
        return associatedClass;
    }

    public void setAssociatedClass(String associatedClass) {
        this.associatedClass = associatedClass;
    }
}
