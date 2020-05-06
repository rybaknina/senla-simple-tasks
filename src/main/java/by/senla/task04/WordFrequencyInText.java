package by.senla.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 * Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
 * Текст и слово вводится вручную.
 *
 */

public class WordFrequencyInText {
    private static void inputTextAndWord() throws IOException {
        String text;
        String word;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Input text (tap \"exit\" to complete):");
                text = br.readLine().trim();
                if (text.equalsIgnoreCase("exit")) break;
                if (text.isEmpty()) {
                    System.out.println("Try again...");
                    continue;
                }
                System.out.println("Input word (tap \"exit\" to complete):");
                word = br.readLine().trim();
                if (word.equalsIgnoreCase("exit")) break;
                if (word.isEmpty()) {
                    System.out.println("It's a bad attempt. Try again...");
                    continue;
                }
                printCountIgnoreCase(text.replaceAll("\\s+"," "), word);
            }
        }
    }
    private static void printCountIgnoreCase(String text, String word){
        long count = Arrays.stream(text.split(" "))
                .filter(x -> x.equalsIgnoreCase(word))
                .count();
        System.out.println("Word frequency in the text is " + count);
    }
    public static void main(String[] args) throws IOException {
        inputTextAndWord();
    }
}
