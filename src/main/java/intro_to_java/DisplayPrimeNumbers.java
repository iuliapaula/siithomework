package intro_to_java;

import java.util.Scanner;

public class DisplayPrimeNumbers {

    public static void main(String[] args) {
        int number;

        number = getNumberFromKeyboard();
        printPrimeNumbers(number);
    }

    private static int getNumberFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Please insert a number and press enter: ");
        number = scanner.nextInt();
        return number;
    }

    private static boolean isPrimeNumber(int number) {
        boolean isPrimeNumber = true;

        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }

    private static void printPrimeNumbers(int number) {
        for(int i = 1; i <= number; i++) {
            if (isPrimeNumber(i))
                System.out.print(i + " ");
        }
    }


}
