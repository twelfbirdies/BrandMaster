package com.kaplan.pdma.brandmaster;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.StringRes;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class ActivityPlay extends Activity {

    Boolean done = false;
    EditText answer;
    MediaPlayer backmusic,correct,wrong;
    String imagename;
    String answercheck;
    String[] question = {"android", "windows", "apple","mcdonalds","yahoo","starbucks","starhub","singtel",
            "instagram","shell","nike","twitter","adidas","audi","toyota","subaru","lexus","chanel","mitsubishi","disney"};
    public static int check;
    int i=0;
    int id;
    int score = 0;
    public static int highscore=0;
    public static int option=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        if (check==0){
        backmusic = MediaPlayer.create(ActivityPlay.this, R.raw.music);
        backmusic.setLooping(true);
        backmusic.start();}

        correct = MediaPlayer.create(ActivityPlay.this,R.raw.correct);
        wrong = MediaPlayer.create(ActivityPlay.this,R.raw.wrong);


        final TextView TimingRemaining = (TextView) findViewById(R.id.timeremain);
        answer = (EditText) findViewById(R.id.answer);
        final TextView scoredisplay = (TextView)findViewById(R.id.scoredisplay);
        final ImageView questionimage =(ImageView)findViewById(R.id.imageView2);



        if (option==0){
            TimingRemaining.setText("90");
        CountDownTimer countDownTimer = new CountDownTimer(90000, 1000){
            public void onTick(long millisUntilFinished) {
                TimingRemaining.setText(""+ (millisUntilFinished / 1000));
            }

            public void onFinish() {
                TimingRemaining.setText("Time's up");
                done=true;
            }
        }.start();}
        else{
            TimingRemaining.setText("60");
            CountDownTimer countDownTimer = new CountDownTimer(60000, 1000){
                public void onTick(long millisUntilFinished) {
                    TimingRemaining.setText(""+ (millisUntilFinished / 1000));
                }

                public void onFinish() {
                    TimingRemaining.setText("Time's up");
                    done=true;
                }
            }.start();
        }




        Button check = (Button)findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (done==false){//time is not up
                answercheck=answer.getText().toString();
            if (answercheck.equalsIgnoreCase(question[i])){
                  //correct answer
                                score+=1;i+=1;
                                imagename="pic"+i;
                                id= getResources().getIdentifier(imagename,"drawable",getPackageName());
                                questionimage.setImageResource(id);
                                scoredisplay.setText(""+score+"points");
                                answer.setText("");
                                correct.start();
            }else{
                //wrong answer
                wrong.start();
            }
            }
            else{//time is up
                if(highscore<score){
                highscore=score;}
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPlay.this);
                builder.setMessage("Your Score is " +score)
                        .setCancelable(false)
                        .setPositiveButton("Check Highscore", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intenthigh = new Intent(getApplicationContext(), ActivityHigh.class);
                                startActivity(intenthigh);
                            }
                        })
                        .setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent returnmain = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(returnmain);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Good Game!");
                alert.show();
            }
            }
        });




    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("your_int_key",highscore);
        editor.commit();
        if (check==0){
        backmusic.release();}
        finish();
    }




}
