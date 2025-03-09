package com.example.simplecalculatorapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText inputNumber1;
    private EditText inputNumber2;
    private TextView viewSolution;
    private String setOperator = "";
    private boolean equalButtonClicked = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNumber1 = findViewById(R.id.inputNumber1);
        inputNumber2 = findViewById(R.id.inputNumber2);
        viewSolution = findViewById(R.id.viewSolution);
    }

    public void add(View view) {
        float num1 = Float.parseFloat(inputNumber1.getText().toString());
        float num2 = Float.parseFloat(inputNumber2.getText().toString());
        float result = num1 + num2;
        setOperator = "+";
        if (equalButtonClicked) {
            viewSolution.setText(String.valueOf(result));
            equalButtonClicked = false;
        }
    }

    public void subtract(View view) {
        float num1 = Float.parseFloat(inputNumber1.getText().toString());
        float num2 = Float.parseFloat(inputNumber2.getText().toString());
        float result = num1 - num2;
        setOperator = "-";
        if (equalButtonClicked) {
            viewSolution.setText(String.valueOf(result));
            equalButtonClicked = false;
        }
    }

    public void multiply(View view) {
        float num1 = Float.parseFloat(inputNumber1.getText().toString());
        float num2 = Float.parseFloat(inputNumber2.getText().toString());
        float result = num1 * num2;
        setOperator = "x";
        if (equalButtonClicked) {
            viewSolution.setText(String.valueOf(result));
            equalButtonClicked = false;
        }
    }

    public void divide(View view) {
        float num1 = Float.parseFloat(inputNumber1.getText().toString());
        float num2 = Float.parseFloat(inputNumber2.getText().toString());
        setOperator = "/";
        if (num2 != 0) {
            float result = num1 / num2;
            if (equalButtonClicked) {
                viewSolution.setText(String.valueOf(result));
                equalButtonClicked = false;
            }
        }
        else {
            viewSolution.setText("MATH ERROR");
        }
    }

    public void equals(View view) {
        equalButtonClicked = true;
        if (setOperator.equals("+")) {
            add(view);
        }
        else if (setOperator.equals("-")) {
            subtract(view);
        }
        else if (setOperator.equals("x")) {
            multiply(view);
        }
        else if (setOperator.equals("/")) {
            divide(view);
        }
    }
}