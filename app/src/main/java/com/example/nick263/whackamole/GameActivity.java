package com.example.nick263.whackamole;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class GameActivity extends AppCompatActivity {

    Button mole1;
    Button mole2;
    Button mole3;
    Button mole4;
    Button mole5;
    Button mole6;
    Button mole7;
    Button mole8;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    TextView txtValue;
    MediaPlayer mediaPlayer;
    int score;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = 0;
        time = 0;
        mole1 = (Button)findViewById(R.id.mole1);
        mole2 = (Button)findViewById(R.id.mole2);
        mole3 = (Button)findViewById(R.id.mole3);
        mole4 = (Button)findViewById(R.id.mole4);
        mole5 = (Button)findViewById(R.id.mole5);
        mole6 = (Button)findViewById(R.id.mole6);
        mole7 = (Button)findViewById(R.id.mole7);
        mole8 = (Button)findViewById(R.id.mole8);
        Button[] moles = new Button[]{mole1, mole2, mole3, mole4, mole5, mole6, mole7, mole8};
        for(int i=0; i<moles.length; i++){
            moles[i].setVisibility(View.GONE);
        }

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);
        img7 = (ImageView)findViewById(R.id.img7);
        img8 = (ImageView)findViewById(R.id.img8);
        ImageView[] imgViews = new ImageView[]{img1, img2, img3, img4, img5, img6, img7, img8};
        for(int i=0; i<imgViews.length; i++){
            imgViews[i].setVisibility(View.GONE);
        }

        int[] pics = new int[]{R.drawable.kakashi, R.drawable.naruto, R.drawable.rock_lee, R.drawable.sakura, R.drawable.sasuke};

        txtValue = (TextView)findViewById(R.id.score);
        txtValue.setText(Integer.toString(score));

        Date startDate = new Date();
        while(time<=90){
            Date tempDate = new Date();
            int mole = (int)Math.random()*9;
            int res = (int)Math.random()*6;
            imgViews[mole].setImageResource(pics[res]);
            imgViews[mole].setVisibility(View.VISIBLE);
            moles[mole].setVisibility(View.INVISIBLE);

            moles[mole].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    score++;
                }
            });
            Date endDate = new Date();
            while((int)((endDate.getTime() - tempDate.getTime()) / 1000) < res){
                txtValue.setText(Integer.toString(score));
            }
            time = (int)((endDate.getTime() - startDate.getTime()) / 1000);
            imgViews[mole].setVisibility(View.GONE);
            moles[mole].setVisibility(View.GONE);
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.konouha);
        mediaPlayer.start();
    }
}
