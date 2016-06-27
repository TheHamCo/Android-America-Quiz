package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
                        msg += "\n1. Correct! The Declaration of Independence was signed on July 4, 1776.\n";
                    } else {
                        msg += "\n1. Try again!\n";
                    }

                    if (checkQ2()){
                        msg += "\n2. Correct! Alexander Hamilton and Ben Franklin were Founding Fathers, but never presidents.\n";
                    } else {
                        msg += "\n2. Try again!\n";
                    }

                    if (checkQ4()){
                        msg += "\n4. Correct! The First Continental Congress met in Philadelphia, PA.\n";
                    } else {
                        msg += "\n4. Try again!\n";
                    }
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public boolean checkQ1(){
        RadioButton q1Correct = (RadioButton)findViewById(R.id.q1_correct_radio);
        return q1Correct.isChecked();
    }

    public boolean checkQ2(){
        CheckBox q2Correct1 = (CheckBox)findViewById(R.id.q2_correct_checkbox_1);
        CheckBox q2Correct2 = (CheckBox)findViewById(R.id.q2_correct_checkbox_2);
        return q2Correct1.isChecked() && q2Correct2.isChecked();
    }

    public boolean checkQ4(){
        RadioButton q4Correct = (RadioButton)findViewById(R.id.q4_correct_radio);
        return q4Correct.isChecked();
    }
}
