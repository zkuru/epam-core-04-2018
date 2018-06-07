package com.epam.homework;

import lombok.*;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);

        MinElement minElement = getPositionOfMinElement(matrix);

        swapRows(matrix, row, minElement.rowIndex);
        swapColumns(matrix, column, minElement.columnIndex);
        printMatrix(matrix);
    }

    private static void swapRows(int[][] matrix, int a, int b) {
        int[] tmp = matrix[a];
        matrix[a] = matrix[b];
        matrix[b] = tmp;
    }

    private static void swapColumns(int[][] matrix, int a, int b) {
        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[i][a];
            matrix[i][a] = matrix[i][b];
            matrix[i][b] = tmp;
        }
    }

    private static MinElement getPositionOfMinElement(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int rowIndex = 0;
        int columnIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    rowIndex = i;
                    columnIndex = j;
                }
            }
        }
        return new MinElement(rowIndex, columnIndex);
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

    private static void printMatrix(int[][] matrix) {
        System.out.println(matrix.length);

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "   ");
            }
            System.out.println();
        }
    }

    @AllArgsConstructor
    private static class MinElement {
        private int rowIndex;
        private int columnIndex;
    }
}
