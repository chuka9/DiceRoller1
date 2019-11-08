package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Random;




public class MainActivity extends AppCompatActivity {

    int count = 0;
    static ArrayList<String> list = new ArrayList<>();
    public static final String EXTRA_MESSAGE = "Hey";

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        list.add("If you would go anywhere in the world, where would you go?");
        list.add("If you were stranded on a desert island, what three things would you want to take with you?");
        list.add("If you could eat only one food for the rest of your life, what would that be?");
        list.add("If you won a million dollars, what is the first thing you would buy?");
        list.add("If you could spend the day with one fictional character, who would it be?");
        list.add("If you found a magic lantern and a genie gave you a wishes, what would you wish?");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        startActivity(intent);
    }

    /*public void sendMessage2(View view) {
        Intent intent2 = new Intent(this, MainActivity.class);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        String message = tv3.getText().toString();
        intent2.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent2);
    }*/

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

    public void roll_the_dice(View view) {
        EditText et = this.findViewById(R.id.editText);

        TextView tv = this.findViewById(R.id.textView);

        TextView tv2 = this.findViewById(R.id.textView2);
        try {

            int number = Random(7 - 1) + 1;

            tv.setText(Integer.toString(number));

            Integer number2 = Integer.valueOf(et.getText().toString());

            if (number2 == number) {
                tv2.setVisibility(View.VISIBLE);
                counting();
            } else if (number2 > 6) {
                tv.setText("Invalid entry");
            } else {
                tv2.setVisibility(View.INVISIBLE);
            }
        } catch (Exception ex) {
            Log.e("MyErrors", ex.toString());
        }

    }

    public void d_icebreakers(View view) {

        TextView tv4 = this.findViewById(R.id.Score);

        int number3 = Random(list.size());

        tv4.setText(list.get(number3));
    }

    public int Random(int n) {

        Random r = new Random();
        int ran = r.nextInt(n);
        return ran;
    }

    public void counting() {
        TextView tv3 = this.findViewById(R.id.textView2);
        count++;
        tv3.setText(Integer.toString(count));
    }

    public void on_button_click(View view) {

        TextView tv = this.findViewById(R.id.textView);
        TextView tv2 = this.findViewById(R.id.textView2);
        TextView score = this.findViewById(R.id.Score);
        EditText numberInput = this.findViewById(R.id.editText);
        int Score1 = 0;
        score.setText(Integer.toString(Score1));
        Score1++;
        Random r = new Random();
        int number = r.nextInt();
        int num = r.nextInt(6);
        tv.setText(Integer.toString(number));

        String UserInputString = numberInput.getText().toString();
        String number_input1 = score.getText().toString();
        int Points = Integer.parseInt(score.getText().toString());

        //number_input1 = findViewById(R.id.number_input);
        //number_input1.setText(Integer.toString(number_input));


        int number_input = new Integer (UserInputString).intValue();
        if (number_input == r.nextInt(1)) {

            tv2.setText("Congratulations!!!");
            score.setText(Score1);
            Score1++;
        } else {
            tv2.setText("");
        }
    }
}
