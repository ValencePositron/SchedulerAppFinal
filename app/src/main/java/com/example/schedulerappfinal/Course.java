package com.example.schedulerappfinal;

public class Course {
    private String courseName;
    private String time;
    private String instructor;

    public Course(String courseName, String time, String instructor) {
        this.courseName = courseName;
        this.time = time;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTime() {
        return time;
    }

    public String getInstructor() {
        return instructor;
    }
}
