package com.ln1.task1mth2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etfirstvalue, etsecondvalue, tvResult;  // Declared tvResult as EditText as per XML
    Button btnAdd, btnSubs, btnMult, btnDiv;
    Double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etfirstvalue = findViewById(R.id.etfirstvalue);
        etsecondvalue = findViewById(R.id.etsecondvalue);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubs = findViewById(R.id.btnSubs);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        // Set click listeners
        ClickListener();
    }

    public void ClickListener() {
        // Addition Button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("ADD");
            }
        });

        // Subtraction Button
        btnSubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("SUB");
            }
        });

        // Multiplication Button
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("MULT");
            }
        });

        // Division Button
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("DIV");
            }
        });
    }

    // Common method to handle calculations
    private void calculate(String operation) {
        String input1 = etfirstvalue.getText().toString();
        String input2 = etsecondvalue.getText().toString();

        // Check if inputs are not empty
        if (input1.isEmpty() || input2.isEmpty()) {
            tvResult.setText("Please enter both numbers");
            return;
        }

        try {
            num1 = Double.parseDouble(input1);
            num2 = Double.parseDouble(input2);
            Double result = null;

            switch (operation) {
                case "ADD":
                    result = num1 + num2;
                    break;
                case "SUB":
                    result = num1 - num2;
                    break;
                case "MULT":
                    result = num1 * num2;
                    break;
                case "DIV":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        tvResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            // Display the result in tvResult EditText
            tvResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            tvResult.setText("Invalid input");
        }
    }
}