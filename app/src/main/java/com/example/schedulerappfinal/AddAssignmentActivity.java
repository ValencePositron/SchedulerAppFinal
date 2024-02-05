package com.example.schedulerappfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddAssignmentActivity extends AppCompatActivity {

    private EditText editTextAssignmentTitle, editTextDueDate, editTextAssocCourses;
    private Button buttonAddAssignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        // Initialize UI elements
        editTextAssignmentTitle = findViewById(R.id.editTextAssignmentTitle);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        editTextAssocCourses = findViewById(R.id.editTextAssocCourses);
        buttonAddAssignment = findViewById(R.id.buttonAddAssignment);

        // Handle button click
        buttonAddAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAssignment();
            }
        });
    }

    // Method to add a new assignment
    private void addAssignment() {
        // Get input values
        String title = editTextAssignmentTitle.getText().toString().trim();
        String dueDate = editTextDueDate.getText().toString().trim();
        String assocCourses = editTextAssocCourses.getText().toString().trim();

        // Validate input
        if (title.isEmpty() || dueDate.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the assignment object
        Assignment newAssignment = new Assignment(title, dueDate, assocCourses);

        // Add the assignment to the list (implementation needed)
        // For now, we'll just display the input values
        String assignmentDetails = "Assignment Title: " + title + "\nDue Date: " + dueDate + "\nAssociated Course: " + assocCourses;
        // You can add further logic here to save the assignment to a database or perform other actions

        // Show a toast with the assignment details
        Toast.makeText(this, assignmentDetails, Toast.LENGTH_SHORT).show();

        // Finish activity and return to previous screen
        finish();
    }
}
