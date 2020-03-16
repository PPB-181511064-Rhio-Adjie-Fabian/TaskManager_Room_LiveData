package com.example.fragmentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        taskList = init();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(taskList, this);
        recyclerView.setAdapter(taskAdapter);
    }

    private ArrayList<Task> init(){
        ArrayList<Task> list = new ArrayList<>();
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.getAllTask();
        if(c.moveToFirst()){
            do{
                String title = c.getString(1);
                String detail = c.getString(2);
                String level = c.getString(3);
                String deadline = c.getString(4);
                list.add(new Task(title, detail, level, Timestamp.valueOf(deadline)));
            } while (c.moveToNext());
        }
        db.close();
        return list;
    }

    public void onClick(View view){
        Intent i = new Intent("com.example.fragmentapp.SecondaryActivity");
        startActivityForResult(i, 1);
    }

    public void addTaskToDB(Task task){
        DBAdapter db = new DBAdapter(this);
        db.open();
        long id = db.insertTask(task.getTitleTugas(), task.getDetailTugas(), task.getLevelTugas(), task.getDeadLineTugas());
        db.close();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Task newTask = (Task) data.getSerializableExtra("newTask");
                addTaskToDB(newTask);
                taskList.add(newTask);
                taskAdapter = new TaskAdapter(taskList, this);
                recyclerView.setAdapter(taskAdapter);
            }
        }
    }

}
