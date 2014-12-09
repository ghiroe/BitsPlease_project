package com.example.gavin.project327;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class gameHub extends Activity {
    ImageView life1;
    ImageView life2;
    ImageView life3;
    TextView scoreDisplay;
    TextView currentScore;
    static int counter = 0;
    static int score = 0;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hub);

        int state1;
        scoreDisplay = (TextView) findViewById(R.id.score);
        currentScore = (TextView) findViewById(R.id.number_score);
        life1 = (ImageView) findViewById(R.id.life1);
        life2 = (ImageView) findViewById(R.id.life2);
        life3 = (ImageView) findViewById(R.id.life3);
        backButton = (ImageButton) findViewById(R.id.backButton);

        Intent get_intent = getIntent();
        state1 = get_intent.getIntExtra("result", 1);

        if (state1 == 0) {
            if (counter == 0) {
                life2.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                counter++;
                String strScore = String.valueOf(score);
                currentScore.setText(strScore);
                nextGame();
            }
            else if (counter == 1) {
                life1.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                life2.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                counter++;
                String strScore = String.valueOf(score);
                currentScore.setText(strScore);
                nextGame();
            }
            else {
                life1.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                life2.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                life3.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                counter = 0;
                backButton.setClickable(false);
                String strScore = String.valueOf(score);
                currentScore.setText(strScore);
                String final_score = "FINAL SCORE";
                scoreDisplay.setText(String.valueOf(final_score));
                //set timer, go to end activity
                gameOver();
            }
        }
        else if (state1 == 1) {
            counter = 0;
            score = 0;
            nextGame();
        }
        else if (state1 == 2) {
            if (counter == 1) {
                life2.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
            }
            else if (counter == 2) {
                life1.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
                life2.setImageDrawable(getResources().getDrawable(R.drawable.bingbongdead));
            }
            score++;
            String strScore = String.valueOf(score);
            currentScore.setText(strScore);
            nextGame();
        }




            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBack();
                }
            });

        }


    private void gameOver() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                goBack();
            }
        }, 3000);
    }

    private void nextGame() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                ready();
            }
        }, 2000);
    }

    private int getNextActivity(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(3);
    }

    private void goBack() {
        Intent intent = new Intent(gameHub.this, StartMenu.class);
        startActivity(intent);
    }

    private void ready() {
        int nextActivity = getNextActivity();
        if (nextActivity == 0) {
            Intent intent = new Intent(gameHub.this, MainActivity.class);
            startActivity(intent);
        }
        else if (nextActivity == 1) {
            Intent intent = new Intent(gameHub.this, wires_game.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(gameHub.this, math_game.class);
            startActivity(intent);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_hub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
