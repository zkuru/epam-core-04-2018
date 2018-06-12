package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();

        getZeroRowsAndColumns(matrix, zeroRows, zeroColumns);

        printMatrix(removeZeroRowsAndColumns(matrix, zeroRows, zeroColumns));
    }

    private static void getZeroRowsAndColumns(int[][] matrix, Set<Integer> zeroRows, Set<Integer> zeroColumns) {

        for (int i = 0; i < matrix.length; i++) {
            zeroRows.add(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean isZeroColumn = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != 0) {
                    isZeroColumn = false;
                    zeroRows.remove(j);
                }
            }
            if (isZeroColumn) {
                zeroColumns.add(i);
            }
        }
    }

    private static int[][] removeZeroRowsAndColumns(int[][] matrix, Set<Integer> zeroRows, Set<Integer> zeroColumns) {
        int[][] resultMatrix = new int[matrix.length - zeroRows.size()][matrix.length - zeroColumns.size()];
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            int col = 0;
            if (!zeroRows.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    if (!zeroColumns.contains(j)) {
                        resultMatrix[row][col++] = matrix[i][j];
                    }
                }
                row++;
            }
        }
        return resultMatrix;
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
        System.out.println(matrix[0].length);

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "   ");
            }
            System.out.println();
        }
    }
}
