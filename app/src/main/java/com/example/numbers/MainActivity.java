package com.example.numbers;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int counter;
    int secret = new Random().nextInt(10)+1;
    private TextView number;
    private ImageView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "secret:" + secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        number = findViewById(R.id.num);
        result = findViewById(R.id.result_image);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
//                int n = Integer.parseInt(number.getText().toString())+1;
//                number.setText(Integer.toString(n));
                counter++;
                number.setText(String.valueOf(counter));
                result.setAlpha(1.0f);
                result.setVisibility(View.VISIBLE);
                if(counter == secret) {
                    Toast.makeText(MainActivity.this, "haha", Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.sad);
                } else {
                    result.setImageResource(R.drawable.smile);
                    result.animate().alpha(0.0f).setDuration(1200);
                }
            }
        });
    }
    public void zero(View view) {
        counter = 0;
        number.setText(Integer.toString(counter));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
