package junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(scanner.nextLine());
        calculator.calculateExpression();
    }
}


