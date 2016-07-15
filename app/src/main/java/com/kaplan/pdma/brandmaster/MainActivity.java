package com.kaplan.pdma.brandmaster;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgmcheck();
        ActivityPlay.check=0;


        Button buttonplay = (Button) findViewById(R.id.play_button);
        buttonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentplay = new Intent(getApplicationContext(), ActivityPlay.class);
                startActivity(intentplay);
            }
        });
        Button buttonsetting = (Button) findViewById(R.id.setting_button);
        buttonsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsetting = new Intent(getApplicationContext(), ActivitySetting.class);
                startActivity(intentsetting);
            }

        });

        Button buttonhigh = (Button) findViewById(R.id.high_button);
        buttonhigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenthigh = new Intent(getApplicationContext(), ActivityHigh.class);
                startActivity(intenthigh);
            }
        });
    }

    public void bgmcheck (){
    Switch bgmswitch =(Switch)findViewById(R.id.bgm_switch);
    bgmswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                ActivityPlay.check=0;
            }
            else{
                ActivityPlay.check=1;
            }
        }
    });}


    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
