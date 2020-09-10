package com.example.rufat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Stage used to calculate BMI given user specified weight, height, and units
 * @author Aniqa Rahim, Christopher Rosenberger
 */
public class MainActivity extends AppCompatActivity {

    private static final int NUM_PLACES_TO_ROUND = 2;
    private static final int CONVERSION_FACTOR = 703;
    private static final char FLOAT_CHAR = '.';
    public static final String EXTRA_MESSAGE = "this.is.the.key";
    private static final String CALC_ERROR_TEXT = "Please enter both a valid weight and height";
    private static final String ADVICE_ERROR_TEXT = "Please calculate BMI first";
    private static final String AMERICAN_WEIGHT_HINT = "Enter weight in pounds";
    private static final String AMERICAN_HEIGHT_HINT = "Enter height in inches";
    private static final String METRIC_WEIGHT_HINT = "Enter weight in kilograms";
    private static final String METRIC_HEIGHT_HINT = "Enter height in meters";

    private TextView bmiTV;
    private EditText weightET;
    private EditText heightET;
    private RadioButton freedomUnitsRB;

    /**
     * Initializes bmiTV (used to display BMI), weightET (used to get user inputted weight), heightET
     * (used to get user inputted weight), and freedomUnitsRB (used to determine the units selected
     * for weight and height)
     * @param savedInstanceState standard input for onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmiTV = findViewById(R.id.fatnessTV);
        weightET = findViewById(R.id.weightET);
        heightET = findViewById(R.id.heightET);
        freedomUnitsRB = findViewById(R.id.freedomUnitsRB);
    }

    /**
     * Calculates and displays BMI with given user input for weight, height, and units.
     * Displays error if either weight or height is zero or left blank.
     * @param view fatnessButton which has just been clicked
     */
    public void calcBMI(View view) {
        if(weightET.getText().toString().equals("") || heightET.getText().toString().equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), CALC_ERROR_TEXT, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        double weight = Double.parseDouble(weightET.getText().toString());
        double height = Double.parseDouble(heightET.getText().toString());
        if(weight == 0 || height == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), CALC_ERROR_TEXT, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        String bmiText = getBMI(weight, height);
        bmiTV.setText(bmiText);
    }

    /**
     * Sends the application to the second (advice) stage.
     * Displays error if BMI is yet to be successfully calculated.
     * @param view adviceButton which has just been clicked
     */
    public void gotoAdvice(View view) {
        if(bmiTV.getText().toString().equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), ADVICE_ERROR_TEXT, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Intent intent = new Intent(this, RUNeedingAdvice.class);
        String message = bmiTV.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * Switches the hints for weightET and heightET based off which of the two RadioButtons
     * available was just clicked.
     * @param view the RadioButton that was just clicked
     */
    public void switchHint(View view) {
        if(view.equals(freedomUnitsRB)) {
            weightET.setHint(AMERICAN_WEIGHT_HINT);
            heightET.setHint(AMERICAN_HEIGHT_HINT);
        } else {
            weightET.setHint(METRIC_WEIGHT_HINT);
            heightET.setHint(METRIC_HEIGHT_HINT);
        }
    }

    /**
     * Calculates BMI based off of given weight and height
     * @param weight user inputted weight in double form
     * @param height user inputted height in double form
     * @return BMI rounded to two decimal places in String form
     */
    private String getBMI(double weight, double height) {
        double bmi = weight / (height * height);
        if(freedomUnitsRB.isChecked()) {
            bmi *= CONVERSION_FACTOR;
        }
        String bmiText = Double.toString(round(bmi, NUM_PLACES_TO_ROUND));
        while(bmiText.substring(bmiText.indexOf(FLOAT_CHAR) + 1).length() < NUM_PLACES_TO_ROUND) {
            bmiText += "0";
        }
        return bmiText;
    }

    /**
     * Takes in a double and rounds it to given amount of decimal places
     * @param value number to round
     * @param places number of places to round to
     * @return inputted value rounded to places decimal places
     */
    private static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
