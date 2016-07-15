package com.kaplan.pdma.brandmaster;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class ActivitySetting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        RadioButton option1 = (RadioButton)findViewById(R.id.radioButton);
        option1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ActivityPlay.option=0;
                }
                else{
                    ActivityPlay.option=1;
                }
            }
        });

        RadioButton option2 = (RadioButton)findViewById(R.id.radioButton2);
        option2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ActivityPlay.option=1;
                }
                else{
                    ActivityPlay.option=0;
                }
            }
        });


        Button back =(Button)findViewById(R.id.backtomain2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnmain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(returnmain);
            }
        });
    }
}
