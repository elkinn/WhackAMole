package com.example.nick263.whackamole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (ImageButton) findViewById(R.id.startButton);
    }

    public void startGame(View v){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }


}
