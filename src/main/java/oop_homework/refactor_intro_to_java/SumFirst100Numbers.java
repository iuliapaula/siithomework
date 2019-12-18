package oop_homework.refactor_intro_to_java;

public class SumFirst100Numbers {
    public static void main(String[] args) {
        printSum(getSum());
    }

    private static void printSum(int sum) {
        System.out.println("The sum of the first 100 numbers higher than 0 is " + sum);
    }

    private static int getSum() {
        int sum;

        sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
