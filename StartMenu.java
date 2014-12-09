package com.example.gavin.project327;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StartMenu extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView gameName;
        Button startButton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        gameName = (TextView) findViewById(R.id.gameTitle);
        startButton = (Button) findViewById(R.id.StartButton);

        startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartMenu.this, gameHub.class);
                    startGame();
                }
        });
    }

    private void startGame() {
        Intent intent = new Intent(StartMenu.this, gameHub.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_menu, menu);
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
