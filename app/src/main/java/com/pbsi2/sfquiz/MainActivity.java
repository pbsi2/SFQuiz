package com.pbsi2.sfquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    boolean firstQuestion(View view){
      int ansid = view.getId();
      RadioButton rightans = (RadioButton) findViewById(R.id.ans4RadioButton);
      if (rightans.getId() == ansid){
          String good = "\"" + rightans.getText() + "\" is the right answer (10 " + this.getString(R.string.score) + ")";
          Toast.makeText(getApplicationContext(), good, Toast.LENGTH_LONG).show();
          return true;
      } else {
          String bad = "WRONG: \"" + rightans.getText() + "\" is the right answer (0 " + this.getString(R.string.score) + ")";
          Toast.makeText(getApplicationContext(), bad, Toast.LENGTH_LONG).show();
          return false;
      }
    }
}
