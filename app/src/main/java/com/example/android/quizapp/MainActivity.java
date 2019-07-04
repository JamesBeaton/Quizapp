package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.checkbox_daxter;
import static com.example.android.quizapp.R.id.checkbox_knuckles;
import static com.example.android.quizapp.R.id.checkbox_luigi;
import static com.example.android.quizapp.R.id.checkbox_ninty;
import static com.example.android.quizapp.R.string.points;

public class MainActivity extends AppCompatActivity {
    boolean nintySelected, knucklesSelected, daxterSelected, luigiChecked, shenmueSelected, namcoSelected, micro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quizResults(View view) {
        RadioButton ninty = (RadioButton) findViewById(checkbox_ninty);
        nintySelected = ninty.isChecked();

        CheckBox knuckles = (CheckBox) findViewById(checkbox_knuckles);
        knucklesSelected = knuckles.isChecked();

        CheckBox daxter = (CheckBox) findViewById(checkbox_daxter);
        daxterSelected = daxter.isChecked();

        CheckBox luigi = (CheckBox) findViewById(checkbox_luigi);
        luigiChecked = luigi.isChecked();

        RadioButton shenmueTrue = (RadioButton) findViewById(R.id.shenmue_false_1);
        shenmueSelected = shenmueTrue.isChecked();

        RadioButton namcoTrue = (RadioButton) findViewById(R.id.namco_true);
        namcoSelected = namcoTrue.isChecked();

        EditText microTrue = (EditText) findViewById(R.id.autoCompleteTextView1);
        String microNewMachine = microTrue.getText().toString().trim();
        micro = microNewMachine.matches("Xbox One X");

        if (nintySelected && shenmueSelected && namcoSelected && luigiChecked && knucklesSelected && !daxterSelected && micro) {
            winToastMessage();
        } else if (nintySelected) {
            looseToastMessage3();
        } else if (shenmueSelected) {
            looseToastMessage3();
        } else if (namcoSelected) {
            looseToastMessage3();
        } else if (luigiChecked) {
            looseToastMessage3();
        } else if (knucklesSelected) {
            looseToastMessage3();
        } else if (micro) {
            looseToastMessage3();
        } else {
            looseToastMessage2();
        }

    }

    private int Score() {
        int score = 0;
        if (nintySelected) {
            score++;
        }

        if (shenmueSelected) {
            score++;
        }

        if (namcoSelected) {
            score++;
        }

        if (knucklesSelected && luigiChecked && !daxterSelected) {
            score += 1;
        }

        if (micro) {
            score++;
        }
        return score;

    }

    private void winToastMessage() {
        Context context = getApplicationContext();
        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();
        CharSequence CongratulationsText = getString(R.string.Wooohoo) + " " + yourName + " " + getString(R.string.perfectScore) + " " + Score() + " " + getString(points) + " " + getString(R.string.trueGamer);
        int duration = Toast.LENGTH_LONG;

        Toast successToastResult = Toast.makeText(context, CongratulationsText, duration);
        successToastResult.show();
    }

    private void looseToastMessage2() {
        Context context = getApplicationContext();
        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();
        CharSequence looseText = getText(R.string.doBetter) + " " + yourName + " " + getText(R.string.answerQuestions);
        int duration = Toast.LENGTH_LONG;

        Toast looseToastResult = Toast.makeText(context, looseText, duration);
        looseToastResult.show();
    }

    private void looseToastMessage3() {
        Context context = getApplicationContext();
        EditText customerName = (EditText) findViewById(R.id.autoCompleteTextView);
        String yourName = customerName.getText().toString();
        CharSequence looseText = getText(R.string.congratulations) + " " + yourName + " " + getText(R.string.youScored) + " " + Score() + " " + getText(R.string.outOf5);
        int duration = Toast.LENGTH_LONG;

        Toast looseToastResult = Toast.makeText(context, looseText, duration);
        looseToastResult.show();
    }

}