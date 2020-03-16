package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.fragmentapp.REPLY";
    private EditText editTitle;
    private EditText editDetail;
    private EditText editLevel;
    private EditText editDeadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        editTitle = (EditText) findViewById(R.id.edit_title);
        editDetail = (EditText) findViewById(R.id.edit_detail);
        editLevel = (EditText) findViewById(R.id.edit_level);
        editDeadline = (EditText) findViewById(R.id.edit_deadline);

        final Button button = (Button) findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(editTitle.getText()) &&
                        TextUtils.isEmpty(editDetail.getText()) &&
                            TextUtils.isEmpty(editLevel.getText()) &&
                                TextUtils.isEmpty(editDeadline.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                } else{
                    String title = editTitle.getText().toString();
                    String detail = editDetail.getText().toString();
                    String level = editLevel.getText().toString();
                    String deadLine = editDeadline.getText().toString();
                    Task task = new Task(title, detail, level, deadLine);
                    replyIntent.putExtra("newTask", task);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
