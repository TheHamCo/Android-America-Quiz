package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.submit_button);
        if (submitButton != null) {
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String msg = "";
                    if (checkQ1()){
                        msg += "\n1. Correct! The Declaration of Independence was signed on July 4, 1776.";
                    } else {
                        msg += "\n1. Try again!";
                    }
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public boolean checkQ1(){
        RadioButton q1Correct = (RadioButton)findViewById(R.id.q1_radio);
        return q1Correct.isChecked();
    }
}
