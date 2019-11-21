package intro_to_java;

public class SumFirst100Numbers {
    public static void main(String[] args) {
        int sum;

        sum = 0;
        for(int i = 0; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("The sum of the first 100 numbers higher than 0 is " + sum);
    }
}
