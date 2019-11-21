package intro_to_java;

import java.util.Scanner;

public class MaxDigitOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a number:");
        int number = scanner.nextInt();
        int maximumDigit = 0;
        while(number > 0)
        {
            if(number % 10 > maximumDigit)
                maximumDigit = number % 10;
            number = number / 10;
        }
        System.out.println("Maximum digit of number is: " + maximumDigit);
    }
}
