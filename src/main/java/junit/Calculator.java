package junit;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String expression;
    private String outputUnitMeasure;
    private String[] arrayToCalculate;

    public double calculateExpression() {
        List<Integer> numbers = new ArrayList<>();
        List<String> unitMeasure = new ArrayList<>();
        List<String> operator = new ArrayList<>();

        arrayToCalculate();
        int length = arrayToCalculate.length;
        for (int i = 0; i < length; ) {
            numbers.add(Integer.parseInt(arrayToCalculate[i]));
            i++;
            unitMeasure.add(arrayToCalculate[i]);
            i++;
            if (i < length) {
                operator.add(arrayToCalculate[i]);
                i++;
            }
        }

        int countOfNumbers = numbers.size();
        int result;
        if (numbers.size() == 0) {
            result = 0;
        } else {
            result = convertToMm(numbers.get(0), unitMeasure.get(0));
        }

        for (int i = 1; i < countOfNumbers; i++) {
            result = calculate(result, convertToMm(numbers.get(i), unitMeasure.get(i)), operator.get(i - 1));
        }
        System.out.println("Result is: " + convertToOutputMeasure(result, outputUnitMeasure) + " " + outputUnitMeasure);
        return convertToOutputMeasure(result, outputUnitMeasure);
    }

    private static int convertToMm(int number, String unitMeasure) {
        switch (unitMeasure) {
            case "cm":
                return number * 10;
            case "dm":
                return number * 100;
            case "m":
                return number * 1_000;
            case "km":
                return number * 1_000_000;
            default:
                return number;
        }
    }

    private static double convertToOutputMeasure(int number, String outputUnitMeasure) {
        switch (outputUnitMeasure) {
            case "mm":
                return number;
            case "cm":
                return (double) number / 10;
            case "dm":
                return (double) number / 100;
            case "m":
                return (double) number / 1_000;
            case "km":
                return (double) number / 1_000_000;
            default:
                return number;
        }
    }

    private static int calculate(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            default:
                return firstNumber;
        }
    }

    //get an array from the expression string
    public void arrayToCalculate() {
        arrayToCalculate = expression.split("\\s");
    }

    public Calculator(String expression, String outputUnitMeasure) {
        this.expression = expression;
        this.outputUnitMeasure = outputUnitMeasure;
    }
}