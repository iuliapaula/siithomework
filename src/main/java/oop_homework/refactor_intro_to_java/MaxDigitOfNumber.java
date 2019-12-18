package oop_homework.refactor_intro_to_java;

import java.util.Scanner;

public class MaxDigitOfNumber {
    public static void main(String[] args) {
        printNumber(getMaximumDigit(getNumber()));
    }

    private static void printNumber(int maximumDigit) {
        System.out.println("Maximum digit of number is: " + maximumDigit);
    }

    private static int getMaximumDigit(int number) {
        int maximumDigit = 0;
        if (number < 0)
            number = -number;
        while(number > 0) {
            if(number % 10 > maximumDigit) {
                maximumDigit = number % 10;
            }
            number = number / 10;
        }
        return maximumDigit;
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a number:");
        return scanner.nextInt();
    }
}
