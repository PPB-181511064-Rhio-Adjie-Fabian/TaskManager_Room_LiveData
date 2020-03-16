package com.example.fragmentapp;

//import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;

public class Task implements Serializable {
    private String titleTugs, detailTugas, levelTugas;
    private Timestamp deadLineTugas;

    public Task(String title, String detail, String level, Timestamp deadline){
        this.titleTugs = title;
        this.detailTugas = detail;
        this.levelTugas = level;
        this.deadLineTugas = deadline;
    }
    public Task() {}

    public String getTitleTugas() {
        return titleTugs;
    }

    public String getDetailTugas() {
        return detailTugas;
    }

    public String getLevelTugas() {
        return levelTugas;
    }

    public Timestamp getDeadLineTugas() {
        return deadLineTugas;
    }

    public void setTitleTugs(String titleTugs) {
        this.titleTugs = titleTugs;
    }

    public void setDetailTugas(String detailTugas) {
        this.detailTugas = detailTugas;
    }

    public void setDeadLineTugas(Timestamp deadLineTugas) {
        this.deadLineTugas = deadLineTugas;
    }

    public void setLevelTugas(String levelTugas) {
        this.levelTugas = levelTugas;
    }
}
