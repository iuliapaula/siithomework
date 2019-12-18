package oop_homework.refactor_intro_to_java;

public class SmallestNumberInArray {
    private static int smallestNumber(int[] array) {
        int smallestNumber;
        int arrayLength;

        smallestNumber = array[0];
        arrayLength = array.length;
        for(int i = 0; i < arrayLength; i++) {
            if (array[i] < smallestNumber)
                smallestNumber = array[i];
        }
        return smallestNumber;
    }

    private static int smallestNumberVersion2(int[] array) {
        int smallestNumber;

        smallestNumber = array[0];
        for(int i : array) {
            if (i < smallestNumber)
                smallestNumber = i;
        }
        return smallestNumber;
    }

    public static void main(String[] args) {
        int[] array = {4, -5, 30};
        System.out.println(smallestNumber(array));
        System.out.println(smallestNumberVersion2(array));
    }
}
