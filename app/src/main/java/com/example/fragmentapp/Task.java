package com.example.fragmentapp;

//import java.util.Date;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity(tableName = "task_table")
public class Task implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int index;
    @NonNull
    @ColumnInfo(name = "title")
    private String titleTugas;
    @NonNull
    @ColumnInfo(name = "detail")
    private String detailTugas;
    @NonNull
    @ColumnInfo(name = "level")
    private String levelTugas;
    @NonNull
    @ColumnInfo(name = "deadline")
    private String deadLineTugas;

    public Task(String title, String detail, String level, String deadline){
        this.titleTugas = title;
        this.detailTugas = detail;
        this.levelTugas = level;
        this.deadLineTugas = deadline;
    }

    public Task() {}

    public String getTitleTugas() {
        return titleTugas;
    }

    public String getDetailTugas() {
        return detailTugas;
    }

    public String getLevelTugas() {
        return levelTugas;
    }

    public String getDeadLineTugas() {
        return deadLineTugas;
    }

    public void setTitleTugas(String titleTugs) {
        this.titleTugas = titleTugs;
    }

    public void setDetailTugas(String detailTugas) {
        this.detailTugas = detailTugas;
    }

    public void setDeadLineTugas(String deadLineTugas) {
        this.deadLineTugas = deadLineTugas;
    }

    public void setLevelTugas(String levelTugas) {
        this.levelTugas = levelTugas;
    }
}
