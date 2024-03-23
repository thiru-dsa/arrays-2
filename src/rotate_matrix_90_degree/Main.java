package rotate_matrix_90_degree;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] array1 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        BruteForce.rotate(array);
        BruteForce.printMatrix(array);
        System.out.println();
        BruteForce.rotate(array1);
        BruteForce.printMatrix(array1);

    }
}

class BruteForce {
    public static void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseEveryRowOfMatrix(matrix);
    }

    private static void reverseEveryRowOfMatrix(int[][] matrix) {
        for(int iterator = 0; iterator < matrix.length; iterator++) {
            for (int jterator = 0; jterator < matrix[0].length / 2; jterator++) {
                System.out.print(jterator + " " + iterator + "   ");
                System.out.println((matrix[0].length - jterator - 1) + " " + iterator);

                int temp = matrix[iterator][jterator];
                matrix[iterator][jterator] = matrix[iterator][(matrix[0].length - jterator - 1)];
                matrix[iterator][(matrix[0].length - jterator - 1)] = temp;

            }
            System.out.println();
        }
    }

    private static void transposeMatrix(int[][] matrix) {
        for(int iterator = 0; iterator < matrix.length; iterator++) {
            for (int jterator = 0; jterator < matrix[0].length ; jterator++) {
                if(jterator > iterator) {
//                    System.out.print(iterator + " " + jterator + "   ");
                    int temp = matrix[iterator][jterator];
                    matrix[iterator][jterator] = matrix[jterator][iterator];
                    matrix[jterator][iterator] = temp;
                }

            }
            System.out.println();
        }
    }
    public static void printMatrix(int[][] matrix) {
        for(int iterator = 0; iterator < matrix.length; iterator++) {
            for(int jterator = 0; jterator < matrix[0].length; jterator++) {
                System.out.print(matrix[iterator][jterator] + " ");
            }
            System.out.println();
        }
    }

}
