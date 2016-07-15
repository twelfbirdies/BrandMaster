package com.kaplan.pdma.brandmaster;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ActivityHigh extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        int myIntValue = sp.getInt("your_int_key", 0);


        final TextView highscore=(TextView)findViewById(R.id.highscoretext);
        highscore.setText(""+myIntValue);

        Button returnbutton = (Button)findViewById(R.id.backbutton);
        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnmain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(returnmain);
            }
        });
    }
}
