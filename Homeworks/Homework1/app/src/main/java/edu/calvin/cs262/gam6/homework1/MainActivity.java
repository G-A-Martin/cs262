/*

Name: Gavin Martin
Class: CS262
Date: September 27, 2018
Prof. Vander-Linden
Title: Homework 1 Calculator App


 */



package edu.calvin.cs262.gam6.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    int optionSelectedPos;
    String optionSelected;
    String value1;
    String value2;
    String finalValue;

    ArrayAdapter<CharSequence> adapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this, R.array.spinnerOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                optionSelected = spinner.getSelectedItem().toString();
                Log.d("selectedThing", optionSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TESTING RESUME FUNCTION", "THIS IS THE RESUME MESSAGE");

        EditText inputVal1 =(EditText)findViewById(R.id.value1);
        inputVal1.setText(value1);
        EditText inputVal2 =(EditText)findViewById(R.id.value2);
        inputVal2.setText(value2);
        // This sets the spinners position to what it was before being paused
        spinner.setSelection(optionSelectedPos);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TESTING PAUSE FUNCTION", "THIS IS THE PAUSE MESSAGE");
        EditText inputVal1 = (EditText) findViewById(R.id.value1);
        value1 = inputVal1.getText().toString();

        EditText inputVal2 = (EditText) findViewById(R.id.value2);
        value2 =  inputVal2.getText().toString();

        // this saves the spinners operator location to be resumed onResume
        optionSelectedPos = spinner.getSelectedItemPosition();


    }

    public void calculateInput(View view) {
        TextView answer = (TextView) findViewById(R.id.answer);
        answer.setText("text you want to display");

        EditText inputVal1 = (EditText) findViewById(R.id.value1);
        value1 = inputVal1.getText().toString();

        EditText inputVal2 = (EditText) findViewById(R.id.value2);
        value2 =  inputVal2.getText().toString();
        optionSelected = spinner.getSelectedItem().toString();

        double calculation;
        double calVal1 = Double.parseDouble(value1);
        double calVal2 = Double.parseDouble(value2);

        switch(optionSelected){
            case "+":
                calculation = calVal1 + calVal2;
                answer.setText(Double.toString(calculation));
                break;
            case "-":
                calculation = calVal1 - calVal2;
                answer.setText(Double.toString(calculation));
                break;
            case "/":
                calculation = calVal1 / calVal2;
                answer.setText(Double.toString(calculation));
                break;
            case "x":
                calculation = calVal1 * calVal2;
                answer.setText(Double.toString(calculation));
                break;
            default:
                answer.setText("Error, Buy an iPhone");
        }

    }
}
