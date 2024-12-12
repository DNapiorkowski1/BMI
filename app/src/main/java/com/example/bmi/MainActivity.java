package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private TextView textViewResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightText = editTextWeight.getText().toString();
        String heightText = editTextHeight.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Proszę wprowadzić wagę i wzrost", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText);

            if (weight <= 0 || height <= 0) {
                Toast.makeText(MainActivity.this, "Waga i wzrost muszą być większe niż zero", Toast.LENGTH_SHORT).show();
                return;
            }

            double bmi = weight / (height * height);

            textViewResult.setText("Twoje BMI: " + String.format("%.2f", bmi));

        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Wprowadź poprawne liczby", Toast.LENGTH_SHORT).show();
        }
    }
}
