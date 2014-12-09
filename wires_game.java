package com.example.gavin.project327;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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


public class wires_game extends Activity {
    int correct = 0;
    ImageButton btnOne;
    ImageButton btnTwo;
    ImageButton btnThree;
    ImageView bingbong1;
    ImageView bingbong2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wires_game);

        final int rando = getIndex(); //This number will be used to pick the blue (0), red (1), or green wire (2)
        final int rando1 = getIndex();//This number will be used to set the color of the text blue text (0), red text (1), green text (2)

        configureText(rando1);
        bingbong1 = (ImageView) findViewById(R.id.imageView1);
        bingbong2 = (ImageView) findViewById(R.id.imageView2);

        btnOne = (ImageButton) findViewById(R.id.imageButton1);//Creates the blue wire
        btnTwo = (ImageButton) findViewById(R.id.imageButton2);//Creates the red wire
        btnThree = (ImageButton) findViewById(R.id.imageButton3);//Creates the green wire

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int targetId = v.getId();
                //View myView = findViewById(R.id.bingbong);
                //If the blue wire is cut, it shows the blue cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 0) {
                    if (targetId == R.id.imageButton1) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_blue);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the red wire is cut, it shows the red cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 1) {
                    if (targetId == R.id.imageButton2) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_red);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the green wire is cut, it shows the green cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 2) {
                    if (targetId == R.id.imageButton3) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_green);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int targetId = v.getId();
                //View myView = findViewById(R.id.bingbong);
                //If the blue wire is cut, it shows the blue cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 0) {
                    if (targetId == R.id.imageButton1) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_blue);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the red wire is cut, it shows the red cut wire. If the other two wires are cut, it shows an explosion.
                else if (rando == 1) {
                    if (targetId == R.id.imageButton2) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_red);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the green wire is cut, it shows the green cut wire. If the other two wires are cut, it shows an explosion.
                else if (rando == 2) {
                    if (targetId == R.id.imageButton3) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_green);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                    }
                    pushed(correct);
                }
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int targetId = v.getId();
                //View myView = findViewById(R.id.bingbong);
                //If the blue wire is cut, it shows the blue cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 0) {
                    if (targetId == R.id.imageButton1) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_blue);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the red wire is cut, it shows the red cut wire. If the other two wires are cut, it shows an explosion.
                if (rando == 1) {
                    if (targetId == R.id.imageButton2) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_red);//Correct wire is cut
                        correct = 2;
                        pushed(correct);
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
                //If the green wire is cut, it shows the green cut wire. If the other two wires are cut, it shows an explosion.
                if (rando != 0 && rando != 1) {
                    if (targetId == R.id.imageButton3) {
                        ((ImageView) v).setImageResource(R.drawable.wires_cut_green);//Correct wire is cut
                        correct = 2;
                    } else {
                        ((ImageView) v).setImageResource(R.drawable.explosion);//Incorrect wire is cut
                        bingbong1.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        bingbong2.setImageDrawable(getResources().getDrawable(R.drawable.explosion));
                        //This should also cause the player to lose a life.
                    }
                    pushed(correct);
                }
            }
        });
    }


    //This will create the instructions and the color of the instructions

    private void configureText(int rando1) {
        TextView textOne = (TextView) findViewById(R.id.textView1);
        if (rando1 == 0) {
            String message = "Cut the blue wire!";
            textOne.setText(String.valueOf(message));
            textOne.setTextColor(Color.BLUE);
        } else if (rando1 == 1) {
            String message1 = "Cut the red wire!";
            textOne.setText(String.valueOf(message1));
            textOne.setTextColor(Color.RED);
        } else {
            String message2 = "Cut the green wire!";
            textOne.setText(String.valueOf(message2));
            textOne.setTextColor(Color.GREEN);
        }
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

    private int getIndex(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(2);
    }
    //There may be needed to be something added in the if else statements for it to continue on to the next game.
    //If possible in ((ImageView) v).setImageResource(R.drawableexplosion); we could set it to link to another screen where the explosion fills the screen.
    //At the moment it just replaces the wire so it is also fine if left like this.

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

