package by.senla.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 * Создать программу, которая будет сообщать,
 * является ли целое число, введенное пользователем,
 * чётным или нечётным, простым или составным.
 * Если пользователь введёт не целое число, то сообщать ему об ошибке.
 *
*/
public class EvenOrOddNumber {

    private static void inputNumber() throws IOException {
        String line;
        Pattern pattern = Pattern.compile("-?[0-9]+");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Input number (tap \"exit\" to complete):");
                line = br.readLine().trim();
                if (line.equalsIgnoreCase("exit")) break;
                if (!pattern.matcher(line).matches()) {
                    System.out.println("Not an integer entered! Try again...");
                    continue;
                }
                printWhichNumberIs(line);
            }
        }
    }

    private static void printWhichNumberIs(String line) {
        Integer number = Integer.parseInt(line);
        System.out.println("Number " + line + " is " +
                ((number % 2 == 0)? "even":"odd") + " and " +
                (BigInteger.valueOf(number).isProbablePrime((int)Math.log(number))?"simple":"compound"));
    }

    public static void main(String[] args) throws IOException {
        inputNumber();
    }

}
