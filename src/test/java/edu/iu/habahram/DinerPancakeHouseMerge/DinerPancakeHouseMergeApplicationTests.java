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
    void testAll() {
        MergerRepository menuMethods = new MergerRepository();// Instantiate your class with the method getBreakfastMenuItems()

        // Act
        List<MenuItemRecord> allItems = menuMethods.getTheMenuItems();
    }
    @Test
    void testBreakfast() {
        // Arrange
        MergerRepository menuMethods = new MergerRepository();// Instantiate your class with the method getBreakfastMenuItems()

        // Act
        List<MenuItemRecord> breakfastItems = menuMethods.getBreakfastMenuItems();

        // Assert
        assertNotNull(breakfastItems);
        assertFalse(breakfastItems.isEmpty());

        // Check for specific items in the breakfast menu
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
    }

    @Test
	void contextLoads() {
	}

}
