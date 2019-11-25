package intro_to_java;

public class CheckSquareArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3},
                            {4, 5},
                            {7, 8, 9}};
        System.out.println(isSquare(matrix));
        System.out.println(isSquare(matrix2));
    }

    public static boolean isSquare(int[][] a) {
        boolean arrayIsSquare = true;

        for (int i = 0, arraySize = a.length; i < arraySize; i++) {
            if (a[i].length != arraySize) {
                arrayIsSquare = false;
                break;
            }
        }
        return arrayIsSquare;
    }
}
