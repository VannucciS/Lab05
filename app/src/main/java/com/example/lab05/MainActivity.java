package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * This app was made for the lab 06 of Mobile development
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =  findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextTextPersonName);


        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String password = editText.getText().toString();
                checkPasswordComplexity(password);
                Toast.makeText(MainActivity.this, "Button is working", Toast.LENGTH_LONG).show();
                TextView textError = findViewById(R.id.textError);
                textError.setText("button clicked");
            }
        });
    }

    private void checkPasswordComplexity(String password) {
        String msg = "";
        TextView textError = findViewById(R.id.textError);

        if(password.contains("#$%^&*!@?")){
            msg = msg +"Your password dos not have special symbols!";
        }

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
    }
}