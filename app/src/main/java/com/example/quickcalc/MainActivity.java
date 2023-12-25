package com.example.quickcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText n1, n2;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide,
            buttonPercentage, buttonLog, buttonExponent, buttonSquareRoot,
            buttonInverse, buttonSin, buttonCos, buttonTan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonPercentage = findViewById(R.id.buttonPercentage);
        buttonLog = findViewById(R.id.buttonLog);
        buttonExponent = findViewById(R.id.buttonExponent);
        buttonSquareRoot = findViewById(R.id.buttonSquareRoot);
        buttonInverse = findViewById(R.id.buttonInverse);
        buttonSin = findViewById(R.id.buttonSin);
        buttonCos = findViewById(R.id.buttonCos);
        buttonTan = findViewById(R.id.buttonTan);

        buttonAdd.setOnClickListener(v -> performOperation('+'));
        buttonSubtract.setOnClickListener(v -> performOperation('-'));
        buttonMultiply.setOnClickListener(v -> performOperation('*'));
        buttonDivide.setOnClickListener(v -> performOperation('/'));

        buttonPercentage.setOnClickListener(v -> performOperation('%'));
        buttonLog.setOnClickListener(v -> performOperation('l')); // assuming log base 10
        buttonExponent.setOnClickListener(v -> performOperation('^'));
        buttonSquareRoot.setOnClickListener(v -> performOperation('√'));
        buttonInverse.setOnClickListener(v -> performOperation('1'));
        buttonSin.setOnClickListener(v -> performOperation('s'));
        buttonCos.setOnClickListener(v -> performOperation('c'));
        buttonTan.setOnClickListener(v -> performOperation('t'));
    }

    private void performOperation(char operation) {
        double num1 = Double.parseDouble(n1.getText().toString());
        double num2 = Double.parseDouble(n2.getText().toString());
        double result = 0;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textView.setText("Cannot divide by zero");
                    return;
                }
                break;
            case '%':
                result = num1 % num2;
                break;
            case 'l':
                result = Math.log10(num1);
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case '√':
                result = Math.sqrt(num1);
                break;
            case '1':
                if (num1 != 0) {
                    result = 1 / num1;
                } else {
                    textView.setText("Cannot divide by zero");
                    return;
                }
                break;
            case 's':
                result = Math.sin(num1);
                break;
            case 'c':
                result = Math.cos(num1);
                break;
            case 't':
                result = Math.tan(num1);
                break;
        }

        textView.setText(String.format(Locale.getDefault(), "Result: %.2f", result));
    }
}
