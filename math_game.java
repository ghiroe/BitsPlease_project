package com.example.gavin.project327;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class math_game extends Activity {
    int correct = 0;
    Button confirm;
    TextView number1;
    TextView number2;
    TextView title;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        int numValue1 = getRandNumber();
        int numValue2 = getRandNumber();
        final int sum = numValue1 + numValue2;
        final String sumStr = String.valueOf(sum);

        title = (TextView) findViewById(R.id.title);
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        answer = (EditText) findViewById(R.id.answer);
        confirm = (Button) findViewById(R.id.confirm);


        number1.setText(String.valueOf(numValue1));
        number2.setText(String.valueOf(numValue2));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_answer = answer.getText().toString();
                if (user_answer.equals(sumStr)) {
                    String yay = "Good job!";
                    title.setText(String.valueOf(yay));
                    correct = 2;
                }
                else {
                    String nay = "Wrong answer!";
                    title.setText(String.valueOf(nay));
                    title.setTextColor(Color.RED);
                }
                pushed(correct);
            }
        });
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
    private int getRandNumber(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(9);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math_game, menu);
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
