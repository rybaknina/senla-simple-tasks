package by.senla.task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 * Создать программу, которая в последовательности от 0 до N,
 * находит все числа-палиндромы (зеркальное значение равно оригинальному).
 * Длина последовательности N вводится вручную и не должна превышать 100.
 *
 */

public class PalindromeNumbers {
    private static void inputCountAndSequences() throws IOException {
        String strCount;
        Pattern pattern = Pattern.compile("-?[0-9]+");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println("Input count (tap \"exit\" to complete):");
                strCount = br.readLine().trim();
                if (strCount.equalsIgnoreCase("exit")) break;
                if (!pattern.matcher(strCount).matches()) {
                    System.out.println("Not an integer entered! Try again...");
                    continue;
                }
                int count = Integer.parseInt(strCount);
                if (count > 100) {
                    System.out.println("Sequence shall not exceed 100");
                    continue;
                }
                System.out.println("Input " + strCount + " numbers (tap \"exit\" to complete):");
                inputAndPrintPalindrome(br, count);
            }
        }
    }
    private static void inputAndPrintPalindrome(BufferedReader br, int count) throws IOException {
        Pattern pattern = Pattern.compile("-?[0-9]+");
        String strNumber;
        List<Integer> integerList = new ArrayList<>();

        for (int i=0; i < count; i++) {
            strNumber = br.readLine().trim();
            if (strNumber.equalsIgnoreCase("exit")) break;
            if (!pattern.matcher(strNumber).matches()) {
                System.out.println("Not an integer entered! Please, try again...");
                continue;
            }
            if (strNumber.equals(new StringBuilder(strNumber).reverse().toString())){
                integerList.add(Integer.parseInt(strNumber));
            }
        }

        System.out.println("Palindromic numbers: ");
        integerList.forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        inputCountAndSequences();
    }
}
