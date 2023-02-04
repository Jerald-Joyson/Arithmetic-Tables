package com.example.arithmetictables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button AddBtn, SubBtn, DivBtn, MulBtn;
    EditText edr, edn;
    int num = 0, rang = 0;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String result = "result";
    public static final String name = "name";
    String abc = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edn = (EditText) findViewById(R.id.numInput);
        edr = (EditText) findViewById(R.id.ranInput);
        AddBtn = (Button) findViewById(R.id.AddBtn);
        SubBtn = (Button) findViewById(R.id.SubBtn);
        DivBtn = (Button) findViewById(R.id.DivBtn);
        MulBtn = (Button) findViewById(R.id.MulBtn);


        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abc = "ADDITION TABLE";
                String edn1 = edn.getText().toString();
                String edr1 = edr.getText().toString();

                if (edn1.isEmpty()) {
                    edn.setError("Please Enter the Number..!");
                } else if (edr1.isEmpty()) {
                    edr.setError("Please Enter the Count..!");
                } else {
                    resultValue(abc, 1);
                }
            }
        });
        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abc = "SUBTRACTION TABLE";
                String edn1 = edn.getText().toString();
                String edr1 = edr.getText().toString();

                if (edn1.isEmpty()) {
                    edn.setError("Please Enter the Number..!");
                } else if (edr1.isEmpty()) {
                    edr.setError("Please Enter the Count..!");
                } else {
                    resultValue(abc, 2);
                }
            }
        });
        DivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abc = "DIVISION TABLE";
                String edn1 = edn.getText().toString();
                String edr1 = edr.getText().toString();

                if (edn1.isEmpty()) {
                    edn.setError("Please Enter the Number..!");
                } else if (edr1.isEmpty()) {
                    edr.setError("Please Enter the Count..!");
                } else {
                    resultValue(abc, 3);
                }
            }
        });
        MulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abc = "MULTIPLICATION TABLE";
                String edn1 = edn.getText().toString();
                String edr1 = edr.getText().toString();

                if (edn1.isEmpty()) {
                    edn.setError("Please Enter the Number..!");
                } else if (edr1.isEmpty()) {
                    edr.setError("Please Enter the Count..!");
                } else {
                    resultValue(abc, 4);
                }
            }
        });
    }

    public void resultValue(String abc, int c) {
        num = Integer.parseInt(edn.getText().toString());
        rang = Integer.parseInt(edr.getText().toString());
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, abc);
        if (c == 1) {
            int i = 0, res = 0;
            StringBuilder ans = new StringBuilder();
            for (i = 1; i <= rang; i++) {
                res = num + i;
                ans.append(String.valueOf(i) + " * " + String.valueOf(num) + "= " + String.valueOf(res) + "\n");
            }
            editor.putString(result, ans.toString());
        } else if (c == 2) {
            int i = 0, res = 0;
            StringBuilder ans = new StringBuilder();
            for (i = 1; i <= rang; i++) {
                res = num - i;
                ans.append(String.valueOf(i) + " * " + String.valueOf(num) + "= " + String.valueOf(res) + "\n");
            }
            editor.putString(result, ans.toString());
        } else if (c == 3) {
            int i = 1, res = 0;
            StringBuilder ans = new StringBuilder();
            int n = num;
            for (i = 1; i <= rang; i++) {
                res = n / num;
                ans.append(String.valueOf(n) + " / " + String.valueOf(num) + "= " + String.valueOf(res) + "\n");
                n = n + num;
            }
            editor.putString(result, ans.toString());
        } else if (c == 4) {
            int i = 0, res = 0;
            StringBuilder ans = new StringBuilder();
            for (i = 1; i <= rang; i++) {
                res = num * i;
                ans.append(String.valueOf(i) + " * " + String.valueOf(num) + "= " + String.valueOf(res) + "\n");
            }
            editor.putString(result, ans.toString());
        } else {
            StringBuilder ans = new StringBuilder();
            ans.append("Error..!!");
            editor.putString(result, ans.toString());
        }

        editor.commit();

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivity(intent);


    }
}