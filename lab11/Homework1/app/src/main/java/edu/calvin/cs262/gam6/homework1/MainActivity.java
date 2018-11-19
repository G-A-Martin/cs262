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
import android.widget.TextView;




/**
 * @author      Gavin Martin
 *
 *  Main Activity class to control and run this application
 *   <p>
 *   This class allows users to add, multiply, subtract, and divide the
 *   numbers given in value1 and value2.
 *   </p>
 *   It provides users the ability to calculate simple mathmatical functions.
 */
public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private int optionSelectedPos;
    private String optionSelected;
    private String value1;
    private String value2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayAdapter<CharSequence> adapter;
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

        EditText inputVal1 = findViewById(R.id.value1);
        inputVal1.setText(value1);
        EditText inputVal2 = findViewById(R.id.value2);
        inputVal2.setText(value2);
        // This sets the spinners position to what it was before being paused
        spinner.setSelection(optionSelectedPos);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TESTING PAUSE FUNCTION", "THIS IS THE PAUSE MESSAGE");
        EditText inputVal1 = findViewById(R.id.value1);
        value1 = inputVal1.getText().toString();

        EditText inputVal2 = findViewById(R.id.value2);
        value2 = inputVal2.getText().toString();

        // this saves the spinners operator location to be resumed onResume
        optionSelectedPos = spinner.getSelectedItemPosition();


    }

    public void calculateInput(View view) {
        TextView answer = findViewById(R.id.answer);
        answer.setText(String.format("text you want to display"));

        EditText inputVal1 = findViewById(R.id.value1);
        value1 = inputVal1.getText().toString();

        EditText inputVal2 = findViewById(R.id.value2);
        value2 = inputVal2.getText().toString();
        optionSelected = spinner.getSelectedItem().toString();

        double calculation;
        double calVal1 = Double.parseDouble(value1);
        double calVal2 = Double.parseDouble(value2);

        switch (optionSelected) {
            case "+":
                calculation = calVal1 + calVal2;
                answer.setText(String.format(Double.toString(calculation)));
                break;
            case "-":
                calculation = calVal1 - calVal2;
                answer.setText(String.format(Double.toString(calculation)));
                break;
            case "/":
                calculation = calVal1 / calVal2;
                answer.setText(String.format(Double.toString(calculation)));
                break;
            case "x":
                calculation = calVal1 * calVal2;
                answer.setText(String.format(Double.toString(calculation)));
                break;
            default:
                answer.setText(String.format("Error, Buy an iPhone"));
        }

    }
}
