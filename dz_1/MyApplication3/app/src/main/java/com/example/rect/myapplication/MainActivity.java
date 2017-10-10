package com.example.rect.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int number = 0;
    public int res = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("111", String.valueOf(number));

        Button buttonPlus = (Button)findViewById(R.id.buttonPlus);
        Button buttonMinus = (Button)findViewById(R.id.buttonMinus);
        Button buttonEq = (Button)findViewById(R.id.buttonEqual);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                TextView myText = (TextView)findViewById(R.id.textView);
                Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();
                number++;
                myText.setText(Integer.toString(number));

            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v){
            TextView myText = (TextView)findViewById(R.id.textView);
            Toast.makeText(getApplicationContext(), "-1", Toast.LENGTH_SHORT).show();

            if (number-1<0){
                number = 0;
            }else{
                number--;
            }

            myText.setText(Integer.toString(number));
        }
    });
        buttonEq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                EditText myText = (EditText)findViewById(R.id.editText4);
                Toast.makeText(getApplicationContext(), "=", Toast.LENGTH_SHORT).show();
                TextView equalText = (TextView)findViewById(R.id.textView3);
                res = Integer.parseInt(myText.getText().toString()) * number;
                equalText.setText(Integer.toString(res));
            }
        });


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        number = savedInstanceState.getInt("number");
        res = savedInstanceState.getInt("result");
        TextView myText = (TextView)findViewById(R.id.textView);
        myText.setText(Integer.toString(number));
        TextView equalText = (TextView)findViewById(R.id.textView3);
        equalText.setText(Integer.toString(res));
        Log.d("111", "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number", number);
        outState.putInt("result", res);

        Log.d("222", "onSaveInstanceState");
    }
}
