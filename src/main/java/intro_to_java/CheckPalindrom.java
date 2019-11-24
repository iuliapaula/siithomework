package intro_to_java;

import java.util.Scanner;

public class CheckPalindrom {

    public static void main(String[] args) {
        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert a number to be checked and press enter: ");
        number = scanner.nextInt();
        int numberOfDigits = getNumberOfDigits(number);

        System.out.println("The number digits " + numberOfDigits);
        for(int i : convertNumberToArray(number))
            System.out.print(i);
        System.out.println(isNumberPalindrom(number));
    }

    private static int getNumberOfDigits(int number) {
        int numberOfDigits = 0;
        for (int numberDuplicate = number; numberDuplicate > 0; numberDuplicate /= 10) {
            numberOfDigits++;
        }
        return numberOfDigits;
    }

    private static int[] convertNumberToArray(int number) {
        int numberOfDigits = getNumberOfDigits(number);
        int[] array = new int[numberOfDigits];

        for (int i = 0; i < numberOfDigits; i++) {
            array[numberOfDigits - i - 1] = number % 10;
            number = number / 10;
        }
        return array;
    }

    private static boolean isNumberPalindrom(int number) {
        int[] numberArray = convertNumberToArray(number);
        boolean checkPalindrom = true;
        for (int i = 0, j = getNumberOfDigits(number) - 1; i < j; i++, j--) {
            if (numberArray[i] != numberArray[j]) {
                checkPalindrom = false;
                break;
            }
        }
        return checkPalindrom;
    }

}
