package com.pbsi2.sfquiz;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int xcore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myview = (TextView) findViewById(R.id.answeredTextView);
        myview.setText("1");
        // Start fragment transaction
        FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        fragQuiz.replace(R.id.question_holder, new Quest1());
        // could also add, but not in this
        // Finish and display
        fragQuiz.commit();
    }

    public void firstQuestion(View view) {
        int ansid = view.getId();
        RadioButton rightans = (RadioButton) findViewById(R.id.ans4RadioButton);
        if (rightans.getId() == ansid) {
            String good = "\"" + rightans.getText() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += 10;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();

            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest2());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("2");
        } else {
            String bad = "WRONG:\"" + rightans.getText() + "\" is the right answer (0 " + this.getString(R.string.score) + ")\nRETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();

            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest1());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("1");
        }

    }

    public void secondQuestion(View view) {

        CheckBox rightans = (CheckBox) findViewById(R.id.first_checkBox);
        CheckBox rightans2 = (CheckBox) findViewById(R.id.second_checkBox);
        CheckBox rightans3 = (CheckBox) findViewById(R.id.third_checkBox);
        CheckBox rightans4 = (CheckBox) findViewById(R.id.forth_checkBox);
        if (rightans.isChecked() && rightans2.isChecked() && !rightans3.isChecked() && !rightans4.isChecked()) {
            String good = "\"" + rightans.getText();
            good += "\n\"" + rightans2.getText();
            good += "\" is the right answer (20 " + this.getString(R.string.score) + ")";
            xcore += 20;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest3());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("3");
        } else {
            String bad = "WRONG: \"" + rightans.getText();
            bad += "\n\"" + rightans2.getText();
            bad += "\" is the right answer (20 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest2());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("2");
        }

    }

    public void thirdQuestion(View view) {

        TextView rightans = (TextView) findViewById(R.id.ans3_1_textView);
        if (rightans.getText().toString().equalsIgnoreCase(getString(R.string.ans3_1))) {
            String good = "\"" + rightans.getText().toString() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += 20;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest4());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("4");
        } else {
            String bad = "WRONG: \"" + getString(R.string.ans3_1) + "\" is the right answer (0 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the frame with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest3());
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("3");
        }


    }

    public void forthQuestion(View view) {
        int ansid = view.getId();
        RadioButton rightans = (RadioButton) findViewById(R.id.ans4_3_RadioButton);
        if (rightans.getId() == ansid) {
            String good = "GOOD: \"" + rightans.getText() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += 10;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest1());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("1(New)");
            setXcore(0);
        } else {
            String bad = "WRONG: \"" + rightans.getText() + "\" is the right answer (0 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest4());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commit();
            TextView myview = (TextView) findViewById(R.id.answeredTextView);
            myview.setText("4");
        }

    }

    public void setXcore(int xcore) {
        String score = String.valueOf(xcore);
        TextView scoreview = (TextView) findViewById(R.id.scoreTextView);
        scoreview.setText(score);
    }
}
