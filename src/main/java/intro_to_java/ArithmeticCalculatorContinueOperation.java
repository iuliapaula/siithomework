package intro_to_java;

import java.util.Scanner;

public class ArithmeticCalculatorContinueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculate (scanner);
    }

    private static double getNumberFromKeyboard(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }

    private static void calculate (Scanner scanner) {
        double result = 0;
        double firstNumber;
        double secondNumber;
        String operator;
        boolean performOperation = true;
        String answer;

        do {
            firstNumber = getNumberFromKeyboard(scanner, "Please insert the first number and press enter: ");
            secondNumber = getNumberFromKeyboard(scanner, "Please insert the second number and press enter: ");
            System.out.println("Enter operator and press enter: ");
            operator = scanner.next();
            switch (operator) {
                case"+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("The operator is not valid!");
            }
            System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is " + result);
            System.out.println("Do you want to continue calculation? Yes/No");
            answer = scanner.next();
            if (answer.equalsIgnoreCase("No"))
                performOperation = false;
        }
        while (performOperation);
    }

}
