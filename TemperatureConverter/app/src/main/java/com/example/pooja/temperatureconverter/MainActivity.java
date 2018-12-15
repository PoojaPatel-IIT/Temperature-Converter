package com.example.pooja.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaring variable "inputText"
    private EditText inputText;
    //declaring variable "outputText"
    private TextView outputText;
    // declaring variable for radio button "F to C"
    private RadioButton f2cRadioButton;
    // declaring variable for radio button "C to F"
    private RadioButton c2fRadioButton;
    // declaring variable for the history storing
    private TextView appendingTextView;
    // For incrementing the count to go to different states
    private int counter = 1;
    private static final String TAG = "ConverterTag";
    private String d;
    private double input_1decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: I am created "+ counter++ + " ****");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding the "inputText" variable to the widget on the screen
        inputText = findViewById(R.id.editText);
        // Binding the "outputText" variable to the widget on the screen
        outputText = findViewById(R.id.textView6);
        // Binding the "f2cRadioButton" variable to the widget on the screen
        f2cRadioButton = findViewById(R.id.radio_f2c);
        // Binding the "c2fRadioButton" variable to the widget on the screen
        c2fRadioButton = findViewById(R.id.radio_c2f);
    // Binding the "appendingTextView" variable to the widget on the screen
        appendingTextView = findViewById(R.id.appendingTextView);

    }


    public void convertButton(View v){

        try {
            String textInput = inputText.getText().toString();
            double c2fVal = Double.parseDouble(textInput);
            double f2cVal = Double.parseDouble(textInput);
            String storedData = appendingTextView.getText().toString();
            Log.d(TAG, "convertButton: I am doing conversion "+ counter++ + " ****");
            appendingTextView.setMovementMethod(new ScrollingMovementMethod());
            if (f2cRadioButton.isChecked()) {
                f2cVal = ((f2cVal - 32.0) / 1.8);
                outputText.setText(String.format("%.1f", f2cVal));
            }
            else if (c2fRadioButton.isChecked()) {
                c2fVal = (c2fVal * 1.8) + 32;
                outputText.setText(String.format("%.1f", c2fVal));

            }

            else {

                Toast.makeText(this,"Please select your conversion choice", Toast.LENGTH_SHORT).show();

            }

            if (f2cRadioButton.isChecked()) {
                // for appending 1 decimal to the input
               String d = inputText.getText().toString();
                double input_1decimal = Double.parseDouble(d);
                appendingTextView.setText("F to C : " + String.format("%.1f", input_1decimal) + "  -->  " + outputText.getText().toString() + "\n"+ storedData);
                //appendingTextView.setText("F to C : " + inputText.getText().toString() + "  -->  " + outputText.getText().toString() + "\n"+ storedData);
            }
            if (c2fRadioButton.isChecked()) {
                // for appending 1 decimal to the input
                String d = inputText.getText().toString();
                double input_1decimal = Double.parseDouble(d);
                appendingTextView.setText("C to F : " + String.format("%.1f", input_1decimal) + "  -->  " + outputText.getText().toString() + "\n"+ storedData);
               // appendingTextView.setText("C to F : " + inputText.getText().toString() + "  -->  " + outputText.getText().toString() + "\n" + storedData);
            }




        }

        catch (Exception e){
            Toast.makeText(this,"You need to input a numeric value", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: "+ counter++ + " ****");

        outState.putString("HISTORY_STORED", appendingTextView.getText().toString());
        outState.putString("out_val",outputText.getText().toString());
       // inputText.setText(" ");
        //outputText.setText(" ");
        super.onSaveInstanceState(outState);
    }

    public void RadioClick(View v){
        if (f2cRadioButton.isChecked()) {
            Toast.makeText(this, "You selected F2C conversion", Toast.LENGTH_SHORT).show();
        }
        else if(c2fRadioButton.isChecked())
            {
            Toast.makeText(this, "You selected C2F conversion", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: "+ counter++ + " ****");
        super.onRestoreInstanceState(savedInstanceState);
        appendingTextView.setText(savedInstanceState.getString("HISTORY_STORED"));
        outputText.setText(savedInstanceState.getString("out_val"));
        //outputText.setText(((String) saved_output1));
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: I am starting "+ counter++ + " ****");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Sad to see you go "+ counter++ + " ****");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: You have destroyed me "+ counter++ + " ****");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: I am paused "+ counter++ + " ****");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: I am back "+ counter++ + " ****");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: I am resumed "+ counter++ + " ****");
    }

}
