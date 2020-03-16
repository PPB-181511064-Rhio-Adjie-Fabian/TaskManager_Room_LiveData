package com.example.fragmentapp;

import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskList {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public TaskList(ArrayList<Task> inputTask){
        taskList = inputTask;
    }

    public TaskList() {}
    private static String[] taskTitle = {
            "Project 4",
            "APSI",
            "PPL"
    };
    private static Timestamp[] taskDeadLine = {
            getDateFormat("03-03-2020 08:00:00"),
            getDateFormat("04-03-2020 08:00:00"),
            getDateFormat("05-03-2020 08:00:00")
    };

    private static String[] taskDetail = {
            "Aplikasi web udah running di server",
            "SOP diperbaiki",
            "Refactor class diagram"
    };

    private static String[] taskLevel = {
            "Tinggi",
            "Menengah",
            "Tinggi"
    };

    public static Timestamp getDateFormat(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        Timestamp result = null;

        try{
            result = (Timestamp) simpleDateFormat.parse(date);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }

    static ArrayList<Task> getTaskList(){
        ArrayList<Task> list = new ArrayList<>();
        for (int index = 0; index < taskTitle.length; index++){
            Task task = new Task();
            task.setTitleTugs(taskTitle[index]);
            task.setDetailTugas(taskDetail[index]);
            task.setDeadLineTugas(taskDeadLine[index]);
            task.setLevelTugas(taskLevel[index]);
            list.add(task);
        }
        return list;
    }
//    public static ArrayList<Task> getTaskList(){
//        Task task = new Task("Project 4", "Aplikasi web udah running di server", "Tinggi", new Date(2020, 3, 3));
//        taskList.add(task);
//        task = new Task("APSI", "SOP diperbaiki", "Menengah", new Date(2020, 3, 4));
//        taskList.add(task);
//        task = new Task("PPL", "Refactor class diagram", "Tinggi", new Date(2020, 3, 5));
//        taskList.add(task);
//        return taskList;
//    }

}
