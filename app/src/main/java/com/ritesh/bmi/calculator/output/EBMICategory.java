package com.ritesh.bmi.calculator.output;

import java.util.Arrays;

/**
 * Enum for BMI categories.
 * 0 < Underweight <= 18.5
 * 18.5 < Normal weight <= 24.9
 * 24.9 < Overweight <= 29.9
 * 29.9 < Obese Class 1 <= 34.9
 * 34.9 < Obese Class 2 <= 39.9
 * 39.9 < Obese Class 3 / Severe Obesity
 */
public enum EBMICategory {
    UNDERWEIGHT("Underweight", 0, 18.5),
    NORMAL_WEIGHT("Normal weight", 18.5, 24.9),
    OVERWEIGHT("Overweight", 24.9, 29.9),
    OBESE_1("Obese Class 1", 29.9, 34.9),
    OBESE_2("Obese Class 2", 34.9, 39.9),
    OBESE_3("Obese Class 3 / Severe Obesity", 39.9, Double.MAX_VALUE);

    private final String displayName;
    private final double lowerValue;
    private final double upperValue;

    EBMICategory(String displayName, double lowerValue, double upperValue) {
        this.displayName = displayName;
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
    }

    // Static method to get category from BMI value
    public static String fromBmi(float bmi) {
        return Arrays.stream(EBMICategory.values())
                .filter(category -> bmi >= category.lowerValue && bmi < category.upperValue)
                .findFirst()
                .map(category -> category.displayName)
                .orElse("Unknown");
    }
}
