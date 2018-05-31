package com.epam.homework;

import java.util.*;

import static java.lang.System.arraycopy;
import static java.lang.System.setOut;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
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
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        int maxElement = max(matrix);

        Set<Integer> rowsToRemove = new HashSet<>();
        Set<Integer> colToRemove = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == maxElement) {
                    rowsToRemove.add(i);
                    colToRemove.add(j);
                }
            }
        }
        printMatrix(removeRowsAndColumnsWithMaxElement(matrix, rowsToRemove, colToRemove));

    }

    private static int[][] removeRowsAndColumnsWithMaxElement(int[][] matrix, Set<Integer> rowsToRemove, Set<Integer> colToRemove) {
        int[][] resultMatrix = new int[matrix.length - rowsToRemove.size()][matrix.length - colToRemove.size()];
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            int col = 0;
            if (!rowsToRemove.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    if (!colToRemove.contains(j)) {
                        resultMatrix[row][col++] = matrix[i][j];
                    }
                }
                row++;
            }
        }
        return resultMatrix;
    }

    private static int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
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
