package com.example.jimenez_calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView display;
    int num1 = 0, num2 = 0;
    String ACTION = "add";  // add, subtract, multiply, divide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // step 1. get first number
        // step 2. get operation (add, subtract, etc.)
        // step 3. get second number
        // step 4. press equals button and display result

        // buttons 0 to 9
        for (int i = 0; i <= 9; i++) {
            final int num = i;
            int resID = getResources().getIdentifier("btn_" + i, "id", getPackageName());
            Button button = findViewById(resID);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentText = display.getText().toString();
                    display.setText(currentText + num);
                }
            });
        }

        // backspace
        Button btnback = (Button)findViewById(R.id.btn_backspace);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = display.getText().toString();
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        // clear button
        Button btnclear = (Button)findViewById(R.id.btn_clear);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                num1 = 0;
                num2 = 0;
            }
        });

        // equals
        Button btnequals = (Button)findViewById(R.id.btn_equals);
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNum2();

                int result = 0;
                switch (ACTION) {
                    case "add":
                        result = num1 + num2;
                        break;
                    case "subtract":
                        result = num1 - num2;
                        break;
                    case "multiply":
                        result = num1 * num2;
                        break;
                    case "divide":
                        result = num1 / num2;
                        break;
                }
                Log.d("Tag", "num1 = " + num1);
                Log.d("Tag", "num2 = " + num2);
                Log.d("Tag", "result = " + result);
                Log.d("Tag", ACTION);
                display.setText(String.valueOf(result));
            }
        });

        // add
        Button btnplus = (Button)findViewById(R.id.btn_plus);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNum1();
                display.setText("");
                ACTION = "add";
            }
        });

        // subtract
        Button btnminus = (Button)findViewById(R.id.btn_minus);
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNum1();
                display.setText("");
                ACTION = "subtract";
            }
        });

        // multiply
        Button btnmultiply = (Button)findViewById(R.id.btn_multiply);
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNum1();
                display.setText("");
                ACTION = "multiply";
            }
        });

        // divide
        Button btndivide = (Button)findViewById(R.id.btn_divide);
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNum1();
                display.setText("");
                ACTION = "divide";
            }
        });
    }

    void getNum1() {
        try {
            num1 = Integer.parseInt(display.getText().toString());
        } catch (NumberFormatException e) {
            num1 = 0;
        }
    }

    void getNum2() {
        try {
            num2 = Integer.parseInt(display.getText().toString());
        } catch (NumberFormatException e) {
            num2 = 0;
        }
    }
}