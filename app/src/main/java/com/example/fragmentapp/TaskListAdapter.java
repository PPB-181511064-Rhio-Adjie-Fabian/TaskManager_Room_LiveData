package com.example.fragmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView detailView;
        private final TextView levelView;
        private final TextView deadLineView;
        private TaskViewHolder(View view){
            super(view);
            titleView = view.findViewById(R.id.title2);
            detailView = view.findViewById(R.id.detail2);
            levelView = view.findViewById(R.id.level2);
            deadLineView = view.findViewById(R.id.deadline2);
        }
    }
    private final LayoutInflater inflater;
    private List<Task> taskList;

    TaskListAdapter(Context context){inflater = LayoutInflater.from(context);}
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(view);
    }
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position){
        if(taskList != null){
            Task current = taskList.get(position);
            holder.titleView.setText(current.getTitleTugas());
            holder.detailView.setText(current.getDetailTugas());
            holder.levelView.setText(current.getLevelTugas());
            holder.deadLineView.setText(current.getDeadLineTugas());
        } else {
            holder.titleView.setText("No Title");
            holder.detailView.setText("No Detail");
            holder.levelView.setText("No Level");
            holder.deadLineView.setText("No Deadline");
        }
    }

    void setTask(List<Task> list){
        taskList = list;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount(){
        if(taskList != null){
            return taskList.size();
        } else {
            return  0;
        }
    }
}
