package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        String tmpWord;
        String wordWithMinimalNumDiffLetters = "";

        HashSet<Character> uniqueCharArray;
        int minCharArraySize = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            uniqueCharArray = new HashSet<>();;
            tmpWord = in.next();

            for (int j = 0; j < tmpWord.length() ; j++) {
                uniqueCharArray.add(tmpWord.charAt(j));
            }
            if (uniqueCharArray.size() <  minCharArraySize) {
                minCharArraySize = uniqueCharArray.size();
                wordWithMinimalNumDiffLetters = tmpWord;
            }
        }

        System.out.println(wordWithMinimalNumDiffLetters);
    }
}
