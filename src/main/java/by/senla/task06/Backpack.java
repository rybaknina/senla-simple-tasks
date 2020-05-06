package by.senla.task06;

import java.util.ArrayList;
import java.util.List;

/**
 * Рюкзак обладает заданной грузоподъемностью.
 */

public class Backpack {
    private double maxWeigth;
    private double bestPrice;
    private List<Item> bestItems;

    public Backpack(double maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public double getMaxWeigth() {
        return maxWeigth;
    }

    public void setMaxWeigth(double maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public double getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(double bestPrice) {
        this.bestPrice = bestPrice;
    }

    private double calculationWeigth(List<Item> items)
    {
        double sumWeigth = 0;
        for(Item item: items){
            sumWeigth += item.getWeigth();
        }
        return sumWeigth;
    }
    private double calculationPrice(List<Item> items)
    {
        double sumPrice = 0;
        for (Item item: items){
            sumPrice += item.getPrice();
        }
        return sumPrice;
    }
    //проверка, является ли данный набор лучшим решением задачи
    private void checkSet(List<Item> items)
    {
        if (bestItems == null){
            if (calculationWeigth(items) <= maxWeigth){
                bestItems = items;
                bestPrice = calculationPrice(items);
            }
        } else {
            if(calculationWeigth(items) <= maxWeigth && calculationPrice(items) > bestPrice){
                bestItems = items;
                bestPrice = calculationPrice(items);
            }
        }
    }
    // создание всех наборов перестановок значений
    void createAllSets(List<Item> items)
    {
        if (items.size() > 0)
            checkSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            createAllSets(newSet);
        }

    }

    public List<Item> getBestItems() {
        return bestItems;
    }
}
