package com.example.gavin.project327;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {
    int correct = 0;
    Button greenBalloon;
    Button yellowBalloon;
    Button blueBalloon;
    Button orangeBalloon;
    Button redBalloon;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int rando1 = getRandomInt();//This number will be used to set the color of the text blue text (0), red text (1), green text (2)


        redBalloon = (Button) findViewById(R.id.button_red);
        greenBalloon = (Button) findViewById(R.id.button_green);
        yellowBalloon = (Button) findViewById(R.id.button_yellow);
        blueBalloon = (Button) findViewById(R.id.button_blue);
        orangeBalloon = (Button) findViewById(R.id.button_orange);
        title = (TextView) findViewById(R.id.balloon_title);

        configureText(rando1);



        redBalloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redBalloon.setBackgroundDrawable(getResources().getDrawable(R.drawable.balloons_popped_red));
                if (rando1 == 1) {
                    correct = 2;
                    String yay = "WAY TO GO!";
                    title.setText(String.valueOf(yay));
                }
                else {
                    String nay = "WRONG BALLOON!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                greenBalloon.setClickable(false);
                yellowBalloon.setClickable(false);
                orangeBalloon.setClickable(false);
                blueBalloon.setClickable(false);
                pushed(correct);
            }
        });


        greenBalloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenBalloon.setBackgroundDrawable(getResources().getDrawable(R.drawable.balloons_popped_green));
                if (rando1 == 2) {
                    correct = 2;
                    String yay = "WAY TO GO!";
                    title.setText(String.valueOf(yay));
                }
                else {
                    String nay = "WRONG BALLOON!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                redBalloon.setClickable(false);
                yellowBalloon.setClickable(false);
                orangeBalloon.setClickable(false);
                blueBalloon.setClickable(false);
                pushed(correct);
            }
        });

        yellowBalloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellowBalloon.setBackgroundDrawable(getResources().getDrawable(R.drawable.balloons_popped_yellow));
                if (rando1 == 3) {
                    correct = 2;
                    String yay = "WAY TO GO!";
                    title.setText(String.valueOf(yay));
                }
                else {
                    String nay = "WRONG BALLOON!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                redBalloon.setClickable(false);
                greenBalloon.setClickable(false);
                orangeBalloon.setClickable(false);
                blueBalloon.setClickable(false);
                pushed(correct);
            }
        });

        blueBalloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueBalloon.setBackgroundDrawable(getResources().getDrawable(R.drawable.balloons_popped_blue));
                if (rando1 == 0) {
                    correct = 2;
                    String yay = "WAY TO GO!";
                    title.setText(String.valueOf(yay));
                }
                else {
                    String nay = "WRONG BALLOON!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                redBalloon.setClickable(false);
                yellowBalloon.setClickable(false);
                orangeBalloon.setClickable(false);
                greenBalloon.setClickable(false);
                pushed(correct);
            }
        });


        orangeBalloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenBalloon.setBackgroundDrawable(getResources().getDrawable(R.drawable.balloons_popped_orange));
                if (rando1 > 3) {
                    correct = 2;
                    String yay = "WAY TO GO!";
                    title.setText(String.valueOf(yay));
                }
                else {
                    String nay = "WRONG BALLOON!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                redBalloon.setClickable(false);
                yellowBalloon.setClickable(false);
                greenBalloon.setClickable(false);
                blueBalloon.setClickable(false);
                pushed(correct);
            }
        });

    }

    private void configureText(int rando1) {
        if (rando1 == 0) {
            String message = "Pop the blue balloon!";
            title.setText(String.valueOf(message));
            title.setTextColor(Color.RED);
        } else if (rando1 == 1) {
            String message1 = "Pop the red balloon!";
            title.setText(String.valueOf(message1));
            title.setTextColor(Color.BLUE);
        } else if (rando1 == 2) {
            String message2 = "Pop the green balloon!";
            title.setText(String.valueOf(message2));
            title.setTextColor(Color.YELLOW);
        } else if (rando1 == 3) {
            String message2 = "Pop the yellow balloon!";
            title.setText(String.valueOf(message2));
            title.setTextColor(Color.GREEN);
        } else {
            String message2 = "Pop the orange balloon!";
            title.setText(String.valueOf(message2));
            title.setTextColor(Color.RED);
        }
    }
    private int getRandomInt(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(5);
    }

    private void pushed(final int result) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                sendPass(result);
            }
        }, 1000);
    }

    private void sendPass(int result) {
        Intent intent = new Intent(this, gameHub.class);
        intent.putExtra("result", result);
        startActivity(intent);
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
