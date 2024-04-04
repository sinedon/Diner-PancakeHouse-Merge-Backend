package edu.iu.habahram.DinerPancakeHouseMerge.model;
import java.util.Iterator;
public class DinerMenu extends Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;

    public DinerMenu(String name, String description) {
        super(name, description);
        add(new MenuItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
        add(new MenuItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        add(new MenuItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29));
        add(new MenuItem("Hotdog",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05));
        add(new MenuItem("Steamed Veggies and Brown Rice",
                "Steamed vegetables over brown rice", true, 3.99));
        add(new MenuItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89));
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full!  Can't add item to menu");
        } else {
            add(menuItem);
            numberOfItems = numberOfItems + 1;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuComponent item: getItems()) {
            stringBuilder.append(item.toString());
        }
        return stringBuilder.toString();
    }
      // other menu methods here
}
