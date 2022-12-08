package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.ParseException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView resultsTV;
    Button sqrtBtn;
    TextView workingsTV;
    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultsTextView);
        sqrtBtn = findViewById(R.id.squareRoot);
        
        sqrtBtn.setOnClickListener((View view) -> {
            String str = workingsTV.getText().toString();
            Double result = Math.sqrt(Double.parseDouble(str));
            resultsTV.setText(String.valueOf(result));
            workingsTV.setText("√" + str);
            workings = String.valueOf(result);
        });
    }

    @SuppressLint("SuspiciousIndentation")
    public void equalOnClick(View view) {
        if (workings.isEmpty()) {
            resultsTV.setText("0");
        }
        else {
            Double result = null;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

            try {
                result = (double)engine.eval(workings);
            }
            catch (ScriptException e) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                result = null;
            }

            if (result != null)
                resultsTV.setText(String.valueOf(result.doubleValue()));
                workings = "";
        }
    }

    public void setWorkings(String givenValue)
    {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("0");
    }

    public static String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        else {
            result = "";
        }
        return result;
    }

    public void delOneSymbolOnClick(View view) {
        workingsTV.setText(removeLastCharacter(workings));
        workings = removeLastCharacter(workings);
    }
    public void changeSign()
    {
        if(workings.charAt(0) == '-'){
            workings = workings.substring(1);
            workingsTV.setText(workings);
        }
        else
        {
            workings = '-' + workings;
            workingsTV.setText(workings);
        }
    }
    public void changeSignOnClick(View view) {
        changeSign();
    }


    public void rootSquareOnClick(View view) {
        setWorkings("√");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void divisionOnClick(View view) {
        setWorkings("/");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void multiplyOnClick(View view) {
        setWorkings("*");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void dotOnClick(View view) {
        setWorkings(".");
    }

    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }


}