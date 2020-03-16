package com.example.fragmentapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<Task>> listLiveData;

    TaskRepository(Application application){
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        taskDao = db.taskDao();
        listLiveData = taskDao.getAlphabetizedTasks();
    }

    LiveData<List<Task>> getAllTask(){
        return listLiveData;
    }

    void insert(Task task){
        TaskRoomDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.insert(task);
        });
    }
}
