package by.senla.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 * Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное) и
 * НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
 * Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 *
 */

public class LCMAndGCDForTwoNumbers {

    private static int gcd(int number1, int number2){
        return (number2 == 0) ? number1 : gcd(number2, number1 % number2);
    }
    private static int lcm(int number1, int number2){
        if (number1 == 0 || number2 == 0) return 0;
        return number1 / gcd(number1, number2) * number2;
    }
    private static void inputNumbers() throws IOException {
        String line1;
        String line2;
        Pattern pattern = Pattern.compile("-?[0-9]+");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Input first number (tap \"exit\" to complete):");
                line1 = br.readLine().trim();
                if (line1.equalsIgnoreCase("exit")) break;
                if (!pattern.matcher(line1).matches()) {
                    System.out.println("Not an integer entered! Try again...");
                    continue;
                }
                System.out.println("Input second number (tap \"exit\" to complete):");
                line2 = br.readLine().trim();
                if (line2.equalsIgnoreCase("exit")) break;
                if (!pattern.matcher(line2).matches()) {
                    System.out.println("Not an integer entered! Try again...");
                    continue;
                }
                printLCMAndGCD(line1, line2);
            }
        }
    }
    private static void printLCMAndGCD(String line1, String line2) {
        Integer number1 = Integer.parseInt(line1);
        Integer number2 = Integer.parseInt(line2);
        System.out.println("The lowest common multiple of " + line1 + " and " + line2 + " = " + lcm(number1, number2));
        System.out.println("The greatest common divisor of " + line1 + " and " + line2 + " = " + gcd(number1, number2));
    }
    public static void main(String[] args) throws IOException {
        inputNumbers();
    }
}
