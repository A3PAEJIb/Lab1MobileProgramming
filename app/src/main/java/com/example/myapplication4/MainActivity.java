package com.example.myapplication4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.lang.*;
import java.util.*;

public class MainActivity extends AppCompatActivity
{
    private static Button buttonSum;
    private static Button buttonMinus;
    private static Button buttonMultiply;
    private static Button buttonDivide;
    private static EditText editText1;
    private static EditText editText2;
    private static TextView textView;
    private static Double a1;
    private static Double a2;
    private static boolean state = true;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating view objects and assigning them to class fields
        buttonSum = findViewById(R.id.button);
        buttonMinus = findViewById(R.id.button2);
        buttonMultiply = findViewById(R.id.button3);
        buttonDivide = findViewById(R.id.button4);
        editText1 = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView2);
        //Call listeners for program(in testing)
        listeners();
    }

    private void listeners()
    {
        buttonSum.setOnClickListener(v ->
        {
            checker(false);
            if(state){textView.setText(String.valueOf(a1 + a2));}

        });
        buttonMinus.setOnClickListener(v ->
        {
            checker(false);
            if(state){textView.setText(String.valueOf(a1 - a2));}
        });
        buttonMultiply.setOnClickListener(v ->
        {
            checker(false);
            if(state){textView.setText(String.valueOf(a1 * a2));}
        });
        buttonDivide.setOnClickListener(v ->
        {
            checker(true);
            if(state){textView.setText(String.valueOf(a1 / a2));}
        });
    }
    private void checker(boolean isDivide)
    {
        //Check module in program.
        if(editText1.length() == 0 || editText2.length() == 0)
        {
            errMsg("Введите оба числовых аргумента");
        }
        else
        {
            try
            {
                a1 = Double.parseDouble(editText1.getText().toString());
                a2 = Double.parseDouble(editText2.getText().toString());
                if(isDivide)
                {
                    if(a2 == 0)
                    {
                        errMsg("На ноль делить нельзя!");
                    }
                    else{state = true;}
                }
                else{state = true;}

            }
            catch (Exception ex)
            {
                errMsg("Введённые данные не соответстуют программе");
            }
        }
    }
    private void errMsg(String Msg)
    {
        //Error message for program
        state = false;
        Toast toast = Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}




