package oop_homework.refactor_intro_to_java;

import java.util.Scanner;

public class DisplayFactorial {
    public static void main(String[] args) {
        int number = getNumberFromKeyboard();

        System.out.println("The factorial of the number " + number + " is equal to: " + computeFactorial(number));
    }

    private static int computeFactorial(int number) {
        if(number == 0)
            return 1;
        else
            return number * computeFactorial (number - 1);
    }

    private static int getNumberFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Please insert a number and press enter: ");
        number = scanner.nextInt();
        return number;
    }
}
