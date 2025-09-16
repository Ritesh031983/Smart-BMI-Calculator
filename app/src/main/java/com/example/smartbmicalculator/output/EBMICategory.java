package com.example.smartbmicalculator.output;

public enum EBMICategory {
    UNDERWEIGHT("Underweight"),
    NORMAL_WEIGHT("Normal weight"),
    OVERWEIGHT("Overweight"),
    OBESE("Obese");

    private final String displayName;

    EBMICategory(String displayName) {
        this.displayName = displayName;
    }

    // Static method to get category from BMI value
    public static EBMICategory fromBmi(float bmi) {
        if (bmi < 18.5) {
            return UNDERWEIGHT;
        } else if (bmi < 24.9) {
            return NORMAL_WEIGHT;
        } else if (bmi < 29.9) {
            return OVERWEIGHT;
        } else {
            return OBESE;
        }
    }
}
