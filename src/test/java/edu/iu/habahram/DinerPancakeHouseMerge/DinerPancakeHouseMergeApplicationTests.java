package edu.iu.habahram.DinerPancakeHouseMerge;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DinerPancakeHouseMergeApplicationTests {

    @Test
    void testAllMenu() {
        MergerRepository menuMethods = new MergerRepository();

        List<MenuItemRecord> allItems = menuMethods.getTheMenuItems();

        assertNotNull(allItems);
        assertFalse(allItems.isEmpty());

        int totalItemCount = allItems.size();

        assertEquals(totalItemCount, 13);
    }

    @Test
    void testBreakfast() {
        MergerRepository menuMethods = new MergerRepository();// Instantiate your class with the method getBreakfastMenuItems()

        List<MenuItemRecord> breakfastItems = menuMethods.getBreakfastMenuItems();

        assertNotNull(breakfastItems);
        assertFalse(breakfastItems.isEmpty());

        boolean foundKAndBPancakeBreakfast = false;
        boolean foundRegularPancakeBreakfast = false;
        boolean foundBlueberryPancakes = false;
        boolean foundWaffles = false;

        for (MenuItemRecord item : breakfastItems) {
            switch (item.name()) {
                case "K&B's Pancake Breakfast" -> foundKAndBPancakeBreakfast = true;
                case "Regular Pancake Breakfast" -> foundRegularPancakeBreakfast = true;
                case "Blueberry Pancakes" -> foundBlueberryPancakes = true;
                case "Waffles" -> foundWaffles = true;
            }
        }

        assertTrue(foundKAndBPancakeBreakfast, "K&B's Pancake Breakfast not found");
        assertTrue(foundRegularPancakeBreakfast, "Regular Pancake Breakfast not found");
        assertTrue(foundBlueberryPancakes, "Blueberry Pancakes not found");
        assertTrue(foundWaffles, "Waffles not found");
        assertEquals(breakfastItems.size(), 4);
    }

    @Test
    void testLunch() {
        MergerRepository menuMethods = new MergerRepository(); // Instantiate your class with the method getLunchMenuItems()

        List<MenuItemRecord> lunchItems = menuMethods.getLunchMenuItems();

        assertNotNull(lunchItems);
        assertFalse(lunchItems.isEmpty());

        boolean foundVegetarianBLT = false;
        boolean foundBLT = false;
        boolean foundSoupOfTheDay = false;
        boolean foundHotdog = false;
        boolean foundSteamedVeggiesAndBrownRice = false;
        boolean foundPasta = false;

        for (MenuItemRecord item : lunchItems) {
            switch (item.name()) {
                case "Vegetarian BLT" -> foundVegetarianBLT = true;
                case "BLT" -> foundBLT = true;
                case "Soup of the day" -> foundSoupOfTheDay = true;
                case "Hotdog" -> foundHotdog = true;
                case "Steamed Veggies and Brown Rice" -> foundSteamedVeggiesAndBrownRice = true;
                case "Pasta" -> foundPasta = true;
            }
        }

        assertTrue(foundVegetarianBLT, "Vegetarian BLT not found");
        assertTrue(foundBLT, "BLT not found");
        assertTrue(foundSoupOfTheDay, "Soup of the day not found");
        assertTrue(foundHotdog, "Hotdog not found");
        assertTrue(foundSteamedVeggiesAndBrownRice, "Steamed Veggies and Brown Rice not found");
        assertTrue(foundPasta, "Pasta not found");
        assertEquals(lunchItems.size(), 6);
    }

    @Test
    void testDinner() {
        MergerRepository menuMethods = new MergerRepository(); // Instantiate your class with the method getDinnerMenuItems()

        List<MenuItemRecord> dinnerItems = menuMethods.getDinnerMenuItems();

        assertNotNull(dinnerItems);
        assertFalse(dinnerItems.isEmpty());

        boolean foundVeggieBurgerAndAirFries = false;
        boolean foundSoupOfTheDay = false;
        boolean foundBurrito = false;

        for (MenuItemRecord item : dinnerItems) {
            switch (item.name()) {
                case "Veggie Burger and Air Fries" -> foundVeggieBurgerAndAirFries = true;
                case "Soup of the day" -> foundSoupOfTheDay = true;
                case "Burrito" -> foundBurrito = true;
            }
        }

        assertTrue(foundVeggieBurgerAndAirFries, "Veggie Burger and Air Fries not found");
        assertTrue(foundSoupOfTheDay, "Soup of the day not found");
        assertTrue(foundBurrito, "Burrito not found");
        assertEquals(dinnerItems.size(), 3);
    }

    @Test
    void testVegetarianMenuItems() {
        MergerRepository menuMethods = new MergerRepository(); // Instantiate your class with the method getVegetarianMenuItems()

        List<MenuItemRecord> vegetarianItems = menuMethods.getVegetarianMenuItems();

        assertNotNull(vegetarianItems);
        assertFalse(vegetarianItems.isEmpty());

        boolean foundVegetarianBLT = false;
        boolean foundSteamedVeggiesAndBrownRice = false;
        boolean foundPasta = false;
        boolean foundBlueberryPancakes = false;
        boolean foundWaffles = false;
        boolean foundVeggieBurgerAndAirFries = false;
        boolean foundBurrito = false;
        boolean foundKAndBPancakeBreakfast = false;

        for (MenuItemRecord item : vegetarianItems) {
            switch (item.name()) {
                case "Vegetarian BLT" -> foundVegetarianBLT = true;
                case "Steamed Veggies and Brown Rice" -> foundSteamedVeggiesAndBrownRice = true;
                case "Pasta" -> foundPasta = true;
                case "Blueberry Pancakes" -> foundBlueberryPancakes = true;
                case "Waffles" -> foundWaffles = true;
                case "Veggie Burger and Air Fries" -> foundVeggieBurgerAndAirFries = true;
                case "Burrito" -> foundBurrito = true;
                case "K&B's Pancake Breakfast" -> foundKAndBPancakeBreakfast = true;
            }
        }

        assertTrue(foundVegetarianBLT, "Vegetarian BLT not found");
        assertTrue(foundSteamedVeggiesAndBrownRice, "Steamed Veggies and Brown Rice not found");
        assertTrue(foundPasta, "Pasta not found");
        assertTrue(foundBlueberryPancakes, "Blueberry Pancakes not found");
        assertTrue(foundWaffles, "Waffles not found");
        assertTrue(foundVeggieBurgerAndAirFries, "Veggie Burger and Air Fries not found");
        assertTrue(foundBurrito, "Burrito not found");
        assertTrue(foundKAndBPancakeBreakfast, "K&B's Pancake Breakfast not found");

        int vegetarianItemCount = vegetarianItems.size();

        assertEquals(vegetarianItemCount, 8);
    }


    @Test
	void contextLoads() {
	}

}
