package com.example.fragmentapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository taskRepository;
    private LiveData<List<Task>> listLiveData;

    public TaskViewModel(Application application){
        super(application);
        taskRepository = new TaskRepository(application);
        listLiveData = taskRepository.getAllTask();
    }

    LiveData<List<Task>> getAllTask(){return this.listLiveData;}
    public void insert(Task task){taskRepository.insert(task);}
}
