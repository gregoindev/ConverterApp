package com.gregorilla.converterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesString = inchesEditText.getText().toString();
                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                } else {
                    double result = calculateMeters(inchesString);
                    MainActivity.this.displayResult(result);
                }
            }
        });
    }


    private double calculateMeters(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.inches_edit_text);
        calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_text_view);
    }

    private void displayResult(double result) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String resultString = decimalFormatter.format(result);
        resultTextView.setText(resultString + " meters");
    }

}