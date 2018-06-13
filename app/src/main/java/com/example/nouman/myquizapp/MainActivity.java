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

    //Instance variables for view elements
    private EditText editTextQ1 = null;
    private RadioGroup radioGroupQ2, radioGroupQ4 = null;
    private CheckBox checkBoxQ31, checkBoxQ32, checkBoxQ33, checkBoxQ34 = null;
    private CheckBox checkBoxQ51, checkBoxQ52, checkBoxQ53, checkBoxQ54 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextQ1 = findViewById(R.id.Q1_EditText);
        radioGroupQ2 = findViewById(R.id.Q2RadioGroupId);
        checkBoxQ31 = findViewById(R.id.Q3CheckBox1);
        checkBoxQ32 = findViewById(R.id.Q3CheckBox2);
        checkBoxQ33 = findViewById(R.id.Q3CheckBox3);
        checkBoxQ34 = findViewById(R.id.Q3CheckBox4);
        radioGroupQ4 = findViewById(R.id.Q4RadioGroupId);
        checkBoxQ51 = findViewById(R.id.Q5CheckBox1);
        checkBoxQ52 = findViewById(R.id.Q5CheckBox2);
        checkBoxQ53 = findViewById(R.id.Q5CheckBox3);
        checkBoxQ54 = findViewById(R.id.Q5CheckBox4);
    }

    String Q1_Solution1 = "8";                  //Question 1 Solution if user enters 8
    String Q1_Solution2 = "eight";              //Question 1 Solution if user enters "eight'
    int Q2_Solution = R.id.Q2Option2;           //Question 2 Solution
    int Q4_Solution = R.id.Q4Option3;           //Question 4 Solution
    int correctQuestions = 0;                   //Correct Ans Count
    int wrongQuestions = 0;                     //Wrong Ans Count

    private void Question1(){
        if (editTextQ1.getText().toString().equalsIgnoreCase(Q1_Solution1) ||
                editTextQ1.getText().toString().equalsIgnoreCase(Q1_Solution2)){
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question2(){
        if (radioGroupQ2.getCheckedRadioButtonId() == Q2_Solution) {
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question3(){
        if (checkBoxQ31.isChecked() && checkBoxQ32.isChecked() && checkBoxQ33.isChecked() && !checkBoxQ34.isChecked()){
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question4(){
        if (radioGroupQ4.getCheckedRadioButtonId() == Q4_Solution) {
            correctQuestions = correctQuestions + 1;
        }
        else{
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question5(){
        if (checkBoxQ51.isChecked() && !checkBoxQ52.isChecked() && checkBoxQ53.isChecked() && checkBoxQ54.isChecked()){
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
            Toast.makeText(getApplicationContext(), String.format(getString(R.string.quizResultText), correctQuestions, wrongQuestions), Toast.LENGTH_LONG).show();
        }
    }

    public void shareResult(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.shareResultText), correctQuestions, wrongQuestions));
        startActivity(Intent.createChooser(share, String.format(getString(R.string.shareResult))));
    }

    public void reset(View view) {
        editTextQ1.setText("");
        radioGroupQ2.clearCheck();
        checkBoxQ31.setChecked(false);
        checkBoxQ32.setChecked(false);
        checkBoxQ33.setChecked(false);
        checkBoxQ34.setChecked(false);
        radioGroupQ4.clearCheck();
        checkBoxQ51.setChecked(false);
        checkBoxQ52.setChecked(false);
        checkBoxQ53.setChecked(false);
        checkBoxQ54.setChecked(false);

        Toast.makeText(getApplicationContext(), R.string.reset, Toast.LENGTH_LONG).show();
    }
}
