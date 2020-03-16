package com.example.fragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ListViewHolder> {
    private ArrayList<Task> taskList;
    private Activity activity;
    public TaskAdapter(ArrayList<Task> list, Activity activity){
        this.taskList = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Task task = taskList.get(position);
        holder.title.setText(task.getTitleTugas());
        holder.deadline.setText(task.getDeadLineTugas().toString());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(".SecondaryActivity");
//                intent.putExtra(SecondaryActivity.keyTitle, task.getTitleTugas());
//                intent.putExtra(SecondaryActivity.keyDetail, task.getDetailTugas());
//                ((Activity) activity).startActivityForResult(intent , 1);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView title, detail, deadline, level;
        public ListViewHolder(@NonNull  View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            deadline = itemView.findViewById(R.id.deadline);
        }
    }
}
