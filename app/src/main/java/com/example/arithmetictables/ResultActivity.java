package com.example.arithmetictables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView NameStr, ResultStr;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ResultStr = (TextView) findViewById(R.id.ResultStr);
        NameStr = (TextView) findViewById(R.id.NameStr);

        prefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String result = prefs.getString("result", "no values");
        String name = prefs.getString("name", "no values");
        ResultStr.setText(result);
        NameStr.setText(name);
    }
}