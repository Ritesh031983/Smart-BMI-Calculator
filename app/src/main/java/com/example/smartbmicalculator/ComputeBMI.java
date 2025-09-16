package com.example.smartbmicalculator;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartbmicalculator.output.BMIResult;

public class ComputeBMI {
    private final EditText editTextWeight;
    private final EditText editTextHeight;
    private final TextView textViewResult;
    private final boolean isHeightInCM;

    public ComputeBMI(EditText editTextWeight,
                      EditText editTextHeight,
                      TextView textViewResult,
                      boolean isHeightInCM
    ) {
        this.editTextWeight = editTextWeight;
        this.editTextHeight = editTextHeight;
        this.textViewResult = textViewResult;
        this.isHeightInCM = isHeightInCM;
    }

    public void compute(MainActivity mainActivity) {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty()) {
            Toast.makeText(mainActivity, R.string.please_enter_weight, Toast.LENGTH_SHORT).show();
            return;
        }

        if (heightStr.isEmpty()) {
            Toast.makeText(mainActivity, R.string.please_enter_height, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            int heightCm = Integer.parseInt(heightStr);

            if (heightCm == 0) {
                Toast.makeText(mainActivity, R.string.height_cannot_be_zero, Toast.LENGTH_SHORT).show();
                return;
            }
            if (heightCm <= 0) {
                Toast.makeText(mainActivity, "Height must be positive", Toast.LENGTH_SHORT).show();
                return;
            }

            float heightInMeters;
            if (isHeightInCM) {
                heightInMeters = (float) heightCm / 100; // Convert cm to meters
            } else {
                heightInMeters = heightCm * 0.0254f; // Convert inches to meters
            }

            // Calculate BMI: weight (kg) / (height (m))^2
            float bmi = weight / (heightInMeters * heightInMeters);
            BMIResult bmiResult = new BMIResult(bmi, textViewResult);
            bmiResult.displayResult();

        } catch (NumberFormatException e) {
            Toast.makeText(mainActivity, R.string.please_enter_valid_numbers, Toast.LENGTH_SHORT).show();
        }
    }
}
