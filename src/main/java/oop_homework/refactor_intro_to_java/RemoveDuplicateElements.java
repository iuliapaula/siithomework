package oop_homework.refactor_intro_to_java;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        int[] array = {20, 20, 30, 40, 50, 50, 50};
        System.out.println(lengthOfUniqueElementsArray(array));
    }

    //keep only unique values from an array and count the number of elements of the array excluding duplicate values
    private static int lengthOfUniqueElementsArray(int[] array) {
        int arrayLength = array.length;
        int[] uniqueElementsArray = new int[arrayLength];
        int numberOfUniqueElements = 0;

        for (int i = 0; i < arrayLength; i++) {
            if (!checkIfPreviouslyEncountered(i, array)) {
                uniqueElementsArray[numberOfUniqueElements] = array[i];
                numberOfUniqueElements++;
            }
        }
        return numberOfUniqueElements;

    }

    //check if an element of the array located at a certain index has been previously encountered in the array
    private static boolean checkIfPreviouslyEncountered (int index, int[] array) {
        boolean checkIfPreviouslyEncountered = false;

        for (int i = 0, checkedNumber = array[index]; i < index; i++) {
            if (array[i] == checkedNumber) {
                checkIfPreviouslyEncountered = true;
                break;
            }
        }
        return checkIfPreviouslyEncountered;
    }
}
