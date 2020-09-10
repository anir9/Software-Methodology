package com.example.rufat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Stage used to display advice given BMI calculated in previous stage
 * @author Aniqa Rahim, Christopher Rosenberger
 */
public class RUNeedingAdvice extends AppCompatActivity {

    private static final double MIN_NORMAL = 18.5;
    private static final double MIN_OVERWEIGHT = 25;
    private static final double MIN_OBESE = 30;
    private static final String UNDERWEIGHT = "Underweight";
    private static final String NORMAL = "Normal";
    private static final String OVERWEIGHT = "Overweight";
    private static final String OBESE = "Obese";
    private static final int UNDERWEIGHT_PIC = R.drawable.underweight;
    private static final int NORMAL_PIC = R.drawable.normal;
    private static final int OVERWEIGHT_PIC = R.drawable.thicc;
    private static final int OBESE_PIC = R.drawable.obese;

    private TextView bmiTV;
    private ImageView bmiIV;

    /**
     * Initializes bmiTV (used to display which range a given BMI falls in) and bmiIV (used to
     * display a picture associated with the calculated range)
     * @param savedInstanceState standard input for onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_u_needing_advice);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bmiTV = findViewById(R.id.bmiTV);
        bmiIV = findViewById(R.id.bmiIV);
    }

    /**
     * Gets BMI from the previous stage, calculates which range said BMI falls in, and changes
     * bmiTV and bmiIV appropriately.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Double bmi = Double.parseDouble(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        if(bmi >= MIN_OBESE) {
            bmiTV.setText(OBESE);
            bmiIV.setImageResource(OBESE_PIC);
        } else if(bmi >= MIN_OVERWEIGHT) {
            bmiTV.setText(OVERWEIGHT);
            bmiIV.setImageResource(OVERWEIGHT_PIC);
        } else if(bmi >= MIN_NORMAL) {
            bmiTV.setText(NORMAL);
            bmiIV.setImageResource(NORMAL_PIC);
        } else {
            bmiTV.setText(UNDERWEIGHT);
            bmiIV.setImageResource(UNDERWEIGHT_PIC);
        }
    }

    /**
     * Sends the application back to the previous stage
     * @param item back button which has just been clicked
     * @return true if the application was successfully returned to the previous stage
     */
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

}
