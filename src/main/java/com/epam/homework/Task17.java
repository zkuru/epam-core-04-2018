package com.epam.homework;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        System.out.println(getMatrixDeterminant(matrix));

    }

    private static int getMatrixDeterminant(int[][] matrix) {
        int dimension = matrix.length;

        switch (dimension) {
            case 1:
                return matrix[0][0];
            case 2:
                return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
            default:
                int det = 0;
                for (int i = 0; i < dimension; i++) {
                    det += pow(-1, i) * matrix[0][i] * getMatrixDeterminant(getMatrixMinor(matrix, i));
                }
                return det;
        }
    }

    private static int[][] getMatrixMinor(int[][] matrix, int removedColumn) {
        int dimension = matrix.length - 1;
        int[][] minor = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++)
                if (removedColumn <= j) {
                    minor[i][j] = matrix[i + 1][j + 1];
                } else {
                    minor[i][j] = matrix[i + 1][j];
                }
        }
        return minor;
    }


    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int column = 0; column < dimension; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
