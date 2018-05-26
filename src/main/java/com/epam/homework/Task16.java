package com.epam.homework;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     * ...
     * case  -5: поворот на 450* против часовой стрелки
     * case  -4: поворот на 360* против часовой стрелки
     * case  -3: поворот на 270* против часовой стрелки
     * case  -2: поворот на 180* против часовой стрелки
     * case  -1: поворот на  90* против часовой стрелки
     * case   0: поворот не осуществляется
     * case   1: поворот на  90* по     часовой стрелке
     * case   2: поворот на 180* по     часовой стрелке
     * case   3: поворот на 270* по     часовой стрелке
     * case   4: поворот на 360* по     часовой стрелке
     * case   5: поворот на 450* по     часовой стрелке
     * ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1  -2   1
     * -3   0   2
     * 3  -2   1
     * 1
     * <p>
     * Выходные данные:
     * 3
     * 3  -3   1
     * -2   0  -2
     * 1   2   1
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 2
     * 9  3
     * 2  4
     * -2
     * <p>
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int degrees = scanner.nextInt();

        printMatrix(rotateMatrix(matrix, degrees));
    }

    private static int[][] rotateMatrix(int[][] matrix, int degrees) {
        if ((degrees %= 4) < 0) {
            degrees += 4;
        }
        switch (degrees) {
            case 1:
                return rotateMatrixOn90degrees(matrix);
            case 2:
                return rotateMatrixOn180degrees(matrix);
            case 3:
                return rotateMatrixOn270degrees(matrix);
        }
        return matrix;
    }

    private static int[][] rotateMatrixOn90degrees(int[][] matrix) {
        int dimension = matrix.length;
        int[][] resMatrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                resMatrix[i][j] = matrix[dimension - j - 1][i];
            }
        }
        return resMatrix;
    }

    private static int[][] rotateMatrixOn180degrees(int[][] matrix) {
        int dimension = matrix.length;
        int[][] resMatrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                resMatrix[i][j] = matrix[dimension - i - 1][dimension - j - 1];
            }
        }
        return resMatrix;
    }

    private static int[][] rotateMatrixOn270degrees(int[][] matrix) {
        int dimension = matrix.length;
        int[][] resMatrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                resMatrix[i][j] = matrix[j][dimension - i - 1];
            }
        }
        return resMatrix;
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
}
