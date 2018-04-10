package com.example.nouman.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String Q1_Solution1 = "8";                  //Question 1 Solution if user enters 8
    String Q1_Solution2 = "eight";              //Question 1 Solution if user enters "eight'
    int Q2_Solution = R.id.Q2Option2;           //Question 2 Solution
    int Q4_Solution = R.id.Q4Option3;           //Question 4 Solution
    int correctQuestions = 0;                   //Correct Ans Count
    int wrongQuestions = 0;                     //Wrong Ans Count

    private void Question1(){
        EditText editTextQ1 = (EditText) findViewById(R.id.Q1_EditText);
        if (editTextQ1.getText().toString().equalsIgnoreCase(Q1_Solution1) ||
                editTextQ1.getText().toString().equalsIgnoreCase(Q1_Solution2)){
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question2(){
        RadioGroup radioGroupQ2 = (RadioGroup) findViewById(R.id.Q2RadioGroupId);
        if (radioGroupQ2.getCheckedRadioButtonId() == Q2_Solution) {
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question3(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.Q3CheckBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.Q3CheckBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.Q3CheckBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.Q3CheckBox4);
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()){
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question4(){
        RadioGroup radioGroupQ4 = (RadioGroup) findViewById(R.id.Q4RadioGroupId);
        if (radioGroupQ4.getCheckedRadioButtonId() == Q4_Solution) {
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question5(){
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.Q5CheckBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.Q5CheckBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.Q5CheckBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.Q5CheckBox4);
        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()){
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    public void submitQuiz(View view) {
        correctQuestions = 0;
        wrongQuestions = 0;
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        if (wrongQuestions == 0){
            Toast.makeText(getApplicationContext(), R.string.allCorrectAns, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "You Got "+correctQuestions+ " Right Answers & "+wrongQuestions+ " Wrong Answers. You Can Retake the Quiz By Clicking Reset Button!", Toast.LENGTH_LONG).show();
        }
    }

    public void shareResult(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "Hey I Got "+correctQuestions+ " Right Answers & "+wrongQuestions+ " Wrong Answers of the Quiz!.");
        startActivity(Intent.createChooser(share, "Share using"));
    }

    public void reset(View view) {
        EditText editTextQ1 = (EditText) findViewById(R.id.Q1_EditText);
        editTextQ1.setText("");

        RadioGroup radioGroupQ2 = (RadioGroup) findViewById(R.id.Q2RadioGroupId);
        radioGroupQ2.clearCheck();

        CheckBox checkBoxQ31 = (CheckBox) findViewById(R.id.Q3CheckBox1);
        checkBoxQ31.setChecked(false);

        CheckBox checkBoxQ32 = (CheckBox) findViewById(R.id.Q3CheckBox2);
        checkBoxQ32.setChecked(false);

        CheckBox checkBoxQ33 = (CheckBox) findViewById(R.id.Q3CheckBox3);
        checkBoxQ33.setChecked(false);

        CheckBox checkBoxQ34 = (CheckBox) findViewById(R.id.Q3CheckBox4);
        checkBoxQ34.setChecked(false);

        RadioGroup radioGroupQ4 = (RadioGroup) findViewById(R.id.Q4RadioGroupId);
        radioGroupQ4.clearCheck();

        CheckBox checkBoxQ51 = (CheckBox) findViewById(R.id.Q5CheckBox1);
        checkBoxQ51.setChecked(false);

        CheckBox checkBoxQ52 = (CheckBox) findViewById(R.id.Q5CheckBox2);
        checkBoxQ52.setChecked(false);

        CheckBox checkBoxQ53 = (CheckBox) findViewById(R.id.Q5CheckBox3);
        checkBoxQ53.setChecked(false);

        CheckBox checkBoxQ54 = (CheckBox) findViewById(R.id.Q5CheckBox4);
        checkBoxQ54.setChecked(false);

        Toast.makeText(getApplicationContext(), R.string.reset, Toast.LENGTH_LONG).show();
    }
}
