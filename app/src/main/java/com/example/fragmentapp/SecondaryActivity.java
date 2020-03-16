package com.example.fragmentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SecondaryActivity extends AppCompatActivity {
    public static final String keyTitle = "title";
    public static final String keyDetail = "detail";
    EditText title, detail, deadline, level;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        title = (EditText) findViewById(R.id.title);
        detail = (EditText) findViewById(R.id.detail);
        deadline = (EditText) findViewById(R.id.deadline);
        level = (EditText) findViewById(R.id.level);
    }

    public void onClick(View view){
        Task newTask = new Task(title.getText().toString(), detail.getText().toString(), level.getText().toString() ,deadline.getText().toString());
        Intent i = new Intent();
        i.putExtra("newTask", newTask);
        setResult(RESULT_OK, i);
        finish();
    }
}
