package junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Output unit is in: ");
        String outputUnitMeasure = scanner.nextLine();
        System.out.println("Expression" );
        String expression = scanner.nextLine();
        Calculator calculator = new Calculator(expression, outputUnitMeasure);
        calculator.calculateExpression();
    }
}


