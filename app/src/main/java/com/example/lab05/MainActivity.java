package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This app was made for the lab 06 of Mobile development
 * @author Vannucci
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {

    /**
     * foundUpperCase show us whether the password have a upper case letter or not
     * foundLowerCase show us whether the password have a lower case letter or not
     * foundNumber show us whether the password have a number or not
     * foundSpecial show us whether the password have any special key or not
     */
    boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial = false;
    /**
     * SPECIAL_CHARACTERES holds the array of special characteres that is expected to be in the password
     */
    private static final Set<Character> SPECIAL_CHARACTERES = new HashSet<>(Arrays.asList('#', '?', '*', '!', '$', '%', '^', '&', '@'));
    /**
     * msg holds the message that will be showed to the user
     */
    private String msg = "";

    /**
     *
     * @param savedInstanceState
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
                if (checkPasswordComplexity(password)){
                    Toast.makeText(MainActivity.this, "Your password meets\n" +
                            "the requirements", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /**
     *
     * @param c
     * @return
     */
    private boolean isSpecialCharacter(char c) {
        return SPECIAL_CHARACTERES.contains(c);
    }

    /**
     *
     * @param password
     * @return
     */
    private boolean checkPasswordComplexity(String password) {
        msg = "";
        /**
         * In this section we will test if the password have the special symbols
         */
        char[] list = password.toCharArray();

        for (char c : list) {
            foundSpecial |= isSpecialCharacter(c);
            foundNumber |= Character.isDigit(c);
            foundUpperCase |= Character.isUpperCase(c);
            foundLowerCase |= Character.isLowerCase(c);
        }
        if(!foundLowerCase){
            msg = msg + "Missing lower case letter\n";
        }
        if(!foundUpperCase){
            msg = msg + "Missing upper case letter\n";
        }
        if(!foundNumber){
            msg = msg + "Missing number\n";
        }
        if(!foundSpecial){
            msg = msg + "Missing special character\n";
        }



        TextView textError = findViewById(R.id.textError);
        textError.setText(msg);
        textError.setTextColor(Color.RED);

        return foundSpecial && foundNumber && foundUpperCase && foundLowerCase;

    }



}