package com.example.bmicalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalculateButton(View view) {
        TextView textResult = (TextView) findViewById(R.id.textResult);
        EditText inputHeight = (EditText) findViewById(R.id.inputHeight);
        EditText inputWeight = (EditText) findViewById(R.id.inputWeight);
        ImageView imageResult = (ImageView) findViewById(R.id.imageResult);

        String stringHeight = inputHeight.getText().toString();
        String stringWeight = inputWeight.getText().toString();

        double doubleHeight = (Double.parseDouble(stringHeight)/100);
        double doubleWeight = Double.parseDouble(stringWeight);
        double result = doubleWeight/doubleHeight/doubleHeight;

        textResult.setText(String.format("Your BMI is %.2f",result));

        if(result<22){
            imageResult.setImageResource(R.drawable.underweight);
        }
        else if(result<=30){
            imageResult.setImageResource(R.drawable.healthy);
        }
        else if(result>30){
            imageResult.setImageResource(R.drawable.obese);
        }

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputHeight.getWindowToken(), 0);
    }


}
