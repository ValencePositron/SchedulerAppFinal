package com.example.schedulerappfinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCourses;
    private CourseAdapter courseAdapter;
    private List<Course> courseList;
    private Button buttonAddCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        recyclerViewCourses = findViewById(R.id.recyclerViewCourses);
        recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list of courses
        courseList = new ArrayList<>();

        // Initialize and set up the adapter
        courseAdapter = new CourseAdapter(courseList);
        recyclerViewCourses.setAdapter(courseAdapter);

        // Initialize Add Course button
        buttonAddCourse = findViewById(R.id.buttonAddCourse);
        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddCourseDialog();
            }
        });
    }

    private void showAddCourseDialog() {
        // Create a dialog for adding a new course
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Course");

        // Inflate the layout for the dialog
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_course, null);
        builder.setView(dialogView);

        // Get references to input fields
        EditText editTextCourseName = dialogView.findViewById(R.id.editTextCourseName);
        EditText editTextTime = dialogView.findViewById(R.id.editTextTime);
        EditText editTextInstructor = dialogView.findViewById(R.id.editTextInstructor);

        // Set up the buttons
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Get the input values
                String courseName = editTextCourseName.getText().toString().trim();
                String time = editTextTime.getText().toString().trim();
                String instructor = editTextInstructor.getText().toString().trim();

                // Add the new course to the list
                Course newCourse = new Course(courseName, time, instructor);
                courseList.add(newCourse);
                courseAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);

        // Show the dialog
        builder.create().show();
    }
}