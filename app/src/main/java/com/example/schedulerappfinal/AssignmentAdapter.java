package com.example.schedulerappfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private List<Assignment> assignmentList;

    public void submitList(List<Assignment> assignments) {
        this.assignmentList = assignments;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_assignment, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignmentList.get(position);
        holder.bind(assignment);
    }

    @Override
    public int getItemCount() {
        return assignmentList != null ? assignmentList.size() : 0;
    }

    static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewAssignmentTitle;
        private TextView textViewDueDate;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAssignmentTitle = itemView.findViewById(R.id.textViewAssignmentTitle);
            textViewDueDate = itemView.findViewById(R.id.textViewDueDate);
        }

        public void bind(Assignment assignment) {
            textViewAssignmentTitle.setText(assignment.getTitle());
            textViewDueDate.setText(assignment.getDueDate());
        }
    }
}
