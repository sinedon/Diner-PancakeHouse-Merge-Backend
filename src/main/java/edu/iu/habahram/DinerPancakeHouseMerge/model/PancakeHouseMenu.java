package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class PancakeHouseMenu extends Menu {

    public PancakeHouseMenu(String name, String description) {
        super(name, description);

        add(new MenuItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99));

        add(new MenuItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99));

        add(new MenuItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49));

        add(new MenuItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59));
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        add(menuItem);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getItems()) {
            stringBuilder.append(item.toString());
        }
        return stringBuilder.toString();
    }
    // other menu methods here
}
