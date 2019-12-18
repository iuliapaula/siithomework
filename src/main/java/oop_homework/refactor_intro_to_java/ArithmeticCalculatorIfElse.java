package oop_homework.refactor_intro_to_java;

import java.util.Scanner;

public class ArithmeticCalculatorIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculate(scanner);
    }

    private static double getNumberFromKeyboard(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    private static void calculate (Scanner scanner) {
        double firstNumber = getNumberFromKeyboard(scanner, "Please insert the first number and press enter: ");
        double secondNumber = getNumberFromKeyboard(scanner, "Please insert the second number and press enter: ");
        System.out.println("Enter operator and press enter: ");
        String operator = scanner.next();
        double result = 0;
        boolean validOperator = true;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        }
        else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        }
        else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        }
        else if (operator.equals("/")) {
            result = firstNumber / secondNumber;
        }
        else {
            System.out.println("The operator is not valid!");
            validOperator = false;
        }
        if(validOperator)
            System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is " + result);
    }
}
