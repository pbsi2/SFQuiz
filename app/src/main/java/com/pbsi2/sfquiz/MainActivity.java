package com.pbsi2.sfquiz;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int xcore = 0;
    int question_1_tries = 0;
    int question_2_tries = 0;
    int question_3_tries = 0;
    int question_4_tries = 0;
    int question_1_points = 10;
    int question_2_points = 20;
    int question_3_points = 10;
    int question_4_points = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myview = findViewById(R.id.answeredTextView);
        myview.setText("1");
        // Start fragment transaction
        FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        fragQuiz.replace(R.id.question_holder, new Quest1());
        // could also add, but not in this
        // Finish and display
        fragQuiz.commitNow();
    }

    public void firstQuestion(View view) {
        int ansid = view.getId();
        RadioButton rightans = findViewById(R.id.ans4RadioButton);
        if (rightans.getId() == ansid) {
            String good = "\"" + rightans.getText() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += question_1_points;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();

            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest2());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("2");
        } else {
            question_1_tries += 1;
            String bad = "WRONG:\"" + rightans.getText() + "\" is the right answer (0 " + this.getString(R.string.score) + ")\nRETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();

            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest1());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("1");
        }

    }

    public void secondQuestion(View view) {

        CheckBox rightans = findViewById(R.id.first_checkBox);
        CheckBox rightans2 = findViewById(R.id.second_checkBox);
        CheckBox rightans3 = findViewById(R.id.third_checkBox);
        CheckBox rightans4 = findViewById(R.id.forth_checkBox);
        if (rightans.isChecked() && rightans2.isChecked() && !rightans3.isChecked() && !rightans4.isChecked()) {
            String good = "\"" + rightans.getText();
            good += "\n\"" + rightans2.getText();
            good += "\" is the right answer (20 " + this.getString(R.string.score) + ")";
            xcore += question_2_points;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest3());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("3");
        } else {
            question_2_tries += 1;
            String bad = "WRONG: \"" + rightans.getText();
            bad += "\n\"" + rightans2.getText();
            bad += "\" is the right answer (20 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest2());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("2");
        }

    }

    public void thirdQuestion(View view) {

        TextView rightans = findViewById(R.id.ans3_1_textView);
        if (rightans.getText().toString().equalsIgnoreCase(getString(R.string.ans3_1))) {
            String good = "\"" + rightans.getText().toString() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += question_3_points;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest4());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("4");
        } else {
            question_3_tries += 1;
            String bad = "WRONG: \"" + getString(R.string.ans3_1) + "\" is the right answer (0 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the frame with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest3());
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("3");
        }


    }

    public void forthQuestion(View view) {
        int ansid = view.getId();
        RadioButton rightans = findViewById(R.id.ans4_3_RadioButton);
        if (rightans.getId() == ansid) {
            String good = "GOOD: \"" + rightans.getText() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
            xcore += question_4_points;
            setXcore(xcore);
            Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Grading());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            fillGrades();
        } else {
            question_4_tries += 1;
            String bad = "WRONG: \"" + rightans.getText() + "\" is the right answer (0 " + this.getString(R.string.score) + ")RETRY____>";
            Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
            FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
            // Replace the contents of the container with the new fragment
            fragQuiz.replace(R.id.question_holder, new Quest4());
            // could also add, but not in this
            // Finish and display
            fragQuiz.commitNow();
            TextView myview = findViewById(R.id.answeredTextView);
            myview.setText("4");
        }

    }

    public void setXcore(int xcore) {
        String score = String.valueOf(xcore);
        TextView scoreview = findViewById(R.id.scoreTextView);
        scoreview.setText(score);
    }
    public void grade(View v){
        FragmentTransaction fragQuiz = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        fragQuiz.replace(R.id.question_holder, new Quest1());
        // could also add, but not in this
        // Finish and display
        fragQuiz.commitNow();
        TextView myview = findViewById(R.id.answeredTextView);
        myview.setText("1(New)");
        setXcore(0);
    }

    public void fillGrades(){
        EditText t1 = findViewById(R.id.try1_edit);
        EditText t2 = findViewById(R.id.try2_edit);
        EditText t3 = findViewById(R.id.try3_edit);
        EditText t4 = findViewById(R.id.try4_edit);
        t1.setText(String.valueOf(question_1_tries));
        t2.setText(String.valueOf(question_2_tries));
        t3.setText(String.valueOf(question_3_tries));
        t4.setText(String.valueOf(question_4_tries));
        EditText p1 = findViewById(R.id.point1_edit);
        EditText p2 = findViewById(R.id.point2_edit);
        EditText p3 = findViewById(R.id.point3_edit);
        EditText p4 = findViewById(R.id.point4_edit);
        p1.setText(String.valueOf(question_4_points));
        p2.setText(String.valueOf(question_2_points));
        p3.setText(String.valueOf(question_3_points));
        p4.setText(String.valueOf(question_4_points));
    }
}
