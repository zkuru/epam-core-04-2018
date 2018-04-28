package com.epam.homework;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        String result = "NOT FOUND";
        int palindromeCount = 0;

        for (int i = 0; i < N; i++) {
            String currentWord = in.next();
            if (!currentWord.equals(result) && isNumber(currentWord)
                    && isPalindrome(currentWord)) {
                result = currentWord;
                palindromeCount++;
                if (palindromeCount == 2) {
                    break;
                }
            }
        }
        System.out.println(result);

    }

    private static boolean isNumber(String tmpStr) {
        for (char c : tmpStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String tmpStr) {
        int i = 0;
        int j = tmpStr.length() - 1;

        while (i < j) {
            if (tmpStr.charAt(i++) != tmpStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
