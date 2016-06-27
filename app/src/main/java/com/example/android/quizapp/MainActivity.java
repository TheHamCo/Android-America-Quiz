package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Submit Button onClickListener
         */
        Button submitButton = (Button)findViewById(R.id.submit_button);
        if (submitButton != null) {
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Grade the quiz, generate the message...
                    String msg = gradeQuizMessage();
                    // ...Display the message in a toast
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    /**
     * Grade question 1
     * Correct answer: July 4, 1776
     * @return Question 1 is correct
     */
    public boolean checkQ1(){
        RadioButton q1Correct = (RadioButton)findViewById(R.id.q1_correct_radio);
        return q1Correct.isChecked();
    }

    /**
     * Generate question 1 grade string
     * @return grade string for question 1
     */
    public String q1Message(){
        if (checkQ1()){
            return "\n1. Correct! The Declaration of Independence was signed on July 4, 1776.\n";
        } else {
            return "\n1. Try again!\n";
        }
    }

    /**
     * Grade question 2
     * Correct answers: George Washington, George Washington
     * @return Question 2 is correct
     */
    public boolean checkQ2(){
        CheckBox q2Correct1 = (CheckBox)findViewById(R.id.q2_correct_checkbox_1);
        CheckBox q2Correct2 = (CheckBox)findViewById(R.id.q2_correct_checkbox_2);
        CheckBox q2Incorrect1 = (CheckBox)findViewById(R.id.q2_incorrect_checkbox_1);
        CheckBox q2Incorrect2 = (CheckBox)findViewById(R.id.q2_incorrect_checkbox_2);

        return q2Correct1.isChecked() && q2Correct2.isChecked() && !q2Incorrect1.isChecked() && !q2Incorrect2.isChecked();
    }

    /**
     * Generate question 2 grade string
     * @return grade string for question 2
     */
    public String q2Message(){
        if (checkQ2()){
            return "\n2. Correct! Alexander Hamilton and Ben Franklin were Founding Fathers, but never presidents.\n";
        } else {
            return "\n2. Try again!\n";
        }
    }

    /**
     * Grade question 3
     * Correct answers (in any order): religion, speech, press, assembly, petition
     * @return Question 3 is correct
     */
    public boolean checkQ3(){
        EditText q3AnswerEditText = (EditText)findViewById(R.id.q3_edittext);
        String q3Answer = q3AnswerEditText.getText().toString().toLowerCase();
        Log.v("Question 3", q3Answer.contains("religion") + "");
        return q3Answer.contains("religion")
                && q3Answer.contains("speech")
                && q3Answer.contains("press")
                && (q3Answer.contains("assembly") || q3Answer.contains("assemble"))
                && q3Answer.contains("petition");
    }

    /**
     * Generate question 3 grade string
     * @return grade string for question 3
     */
    public String q3Message(){
        if (checkQ3()){
            return "\n3. Correct! USA! USA! USA!\n";
        } else {
            return "\n3. Try Again!\n";
        }
    }

    /**
     * Grade question 4
     * Correct answer: Philadelphia, PA
     * @return Question 4 is correct
     */
    public boolean checkQ4(){
        RadioButton q4Correct = (RadioButton)findViewById(R.id.q4_correct_radio);
        return q4Correct.isChecked();
    }

    /**
     * Generate question 4 grade string
     * @return grade string for question 4
     */
    public String q4Message(){
        if (checkQ4()){
            return "\n4. Correct! The First Continental Congress met in Philadelphia, PA.\n";
        } else {
            return "\n4. Try again!\n";
        }
    }

    /**
     * Grade question 5
     * Correct answers: Executive, Legislative, Judicial
     * @return Question 5 is correct
     */
    public boolean checkQ5(){
        CheckBox q5Correct1 = (CheckBox)findViewById(R.id.q5_correct_checkbox_1);
        CheckBox q5Correct2 = (CheckBox)findViewById(R.id.q5_correct_checkbox_2);
        CheckBox q5Correct3 = (CheckBox)findViewById(R.id.q5_correct_checkbox_3);
        CheckBox q5Incorrect = (CheckBox)findViewById(R.id.q5_incorrect_checkbox);
        return q5Correct1.isChecked() && q5Correct2.isChecked() && q5Correct3.isChecked() && !q5Incorrect.isChecked();
    }

    /**
     * Generate question 5 grade string
     * @return grade string for question 5
     */
    public String q5Message(){
        if (checkQ5()){
            return "\n5. Correct!  There is no Financial branch, but the Federal Reserve is the central bank of the US.\n";
        } else {
            return "\n5. Try again!\n";
        }
    }

    /**
     * Generate grade string for all 5 questions
     * @return the grade string for all 5 questions
     */
    public String gradeQuizMessage(){
        return q1Message() + q2Message() + q3Message() + q4Message() + q5Message();
    }
}
