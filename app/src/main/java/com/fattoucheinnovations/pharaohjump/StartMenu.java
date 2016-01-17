package com.fattoucheinnovations.pharaohjump;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.WindowManager;

public class StartMenu extends Activity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {

        /*
        super.onCreate(savedInstanceState);

        //makes the window full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_menu);

        Button startgame = (Button)findViewById(R.id.BeginButton);

            startgame.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                           startActivity(new Intent(StartMenu.this,GamePanel.class));
                    }
                }

        );
*/

        super.onCreate(savedInstanceState);

        //turn title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new GamePanel(this));
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
