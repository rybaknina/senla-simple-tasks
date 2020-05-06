package by.senla.task06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nina Rybak (rybaknin@gmail.com)
 *
 * Имеется набор вещей, которые необходимо поместить в рюкзак.
 * Рюкзак обладает заданной грузоподъемностью.
 * Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
 * Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
 *
 */

public class FilledBackpack {

    private static List<Item> addItems(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("Book", 1, 300));
        items.add(new Item("Аirst-aid kit", 3, 5000));
        items.add(new Item("Laptop", 4, 40000));
        items.add(new Item("Сauldron", 2, 5000));
        items.add(new Item("Guitar", 6, 1500));
        items.add(new Item("Phone", 1, 2000));
        items.add(new Item("Player", 4, 3000));
        return items;
    }

    public static void main(String[] args) {

        // Рюкзак обладает заданной грузоподъемностью
        Backpack backpack = new Backpack(8);
        // создание всех наборов перестановок значений
        backpack.createAllSets(addItems());

        List<Item> bestSolution = backpack.getBestItems();

        bestSolution.forEach(System.out::println);

    }
}
