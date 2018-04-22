package com.epam.homework;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     *
     * Выходные данные:
     * by
     *
     * ===================================================================================================
     *
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     *
     * Выходные данные:
     * NOT FOUND
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();


        String result = "NOT FOUND";

        for (int i = 0; i < N; i++) {
            String currWord = in.next();

            if (currWord.length() > 1) {
                String currWordInLowerCase = currWord.toLowerCase();
                boolean isCharsCodeInAscendingOrder = true;

                for (int j = 0; j < currWordInLowerCase.length() - 1; j++) {
                    if (currWordInLowerCase.charAt(j) >= currWordInLowerCase.charAt(j + 1)) {
                        isCharsCodeInAscendingOrder = false;
                        break;
                    }
                }
                if (isCharsCodeInAscendingOrder) {
                    result = currWord;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
