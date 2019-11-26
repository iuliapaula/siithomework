package intro_to_java;

import java.util.Scanner;

public class CheckPalindromVersion2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a  number and press enter: ");
        int number = scanner.nextInt();
        int duplicateNumber = number;
        int invertedNumber = 0;

        while (duplicateNumber != 0) {
            invertedNumber = invertedNumber * 10 + duplicateNumber % 10;
            duplicateNumber /= 10;
        }
        System.out.println("The number is " + number + ", the inverted number is " + invertedNumber + ".");
        if (number == invertedNumber) {
            System.out.println("The number is a palindrom.");
        }
        else {
            System.out.println("The number is not a palindrom.");
        }


    }
}
