package by.senla.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 *Создать программу, которая будет:
 * подсчитывать количество слов в предложении
 * выводить их в отсортированном виде
 * делать первую букву каждого слова заглавной.
 * Предложение вводится вручную. (Разделитель пробел (“ ”)).
 *
 */

public class SortAndCountWords {

    private static void inputSentence() throws IOException {
        String sentence;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Input text (tap \"exit\" to complete):");
                sentence = br.readLine().trim();
                if (sentence.equalsIgnoreCase("exit")) break;
                printArray(sentence.replaceAll("\\s+"," "));  // remove all spaces more then one
            }
        }
    }
    private static void printArray(String sentence){
        List<String> sortedList = Arrays.stream(sentence.split(" "))
                .sorted()
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.toList());

        System.out.println("Number of words: " + sortedList.size());
        System.out.println("Sorted list:");
        sortedList.forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        inputSentence();
    }
}
