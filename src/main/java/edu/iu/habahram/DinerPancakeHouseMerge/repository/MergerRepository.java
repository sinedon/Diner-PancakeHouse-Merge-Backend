package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {

    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        MenuComponent DinerMenu = new DinerMenu("Diner Menu", "Lunch");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }
    public List<MenuItemRecord> getVegetarianMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> vegetarianItems = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menu = iterator.next();
            if (menu instanceof Menu) {
                Iterator<MenuComponent> menuIterator = menu.createIterator();
                while (menuIterator.hasNext()) {
                    MenuComponent menuItem = menuIterator.next();
                    if (menuItem.isVegetarian()) {
                        vegetarianItems.add(new MenuItemRecord(
                                menuItem.getName(),
                                menuItem.getDescription(),
                                menuItem.isVegetarian(),
                                menuItem.getPrice()
                        ));
                    }
                }
            }
        }

        return vegetarianItems;
    }

    public List<MenuItemRecord> getBreakfastMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> breakfastItems = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menu = iterator.next();
            if (menu instanceof PancakeHouseMenu) {
                Iterator<MenuComponent> menuIterator = menu.createIterator();
                while (menuIterator.hasNext()) {
                    MenuComponent menuItem = menuIterator.next();
                    breakfastItems.add(new MenuItemRecord(
                            menuItem.getName(),
                            menuItem.getDescription(),
                            menuItem.isVegetarian(),
                            menuItem.getPrice()
                    ));
                }
            }
        }

        return breakfastItems;
    }

    public List<MenuItemRecord> getLunchMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> lunchItems = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menu = iterator.next();
            if (menu instanceof DinerMenu) {
                Iterator<MenuComponent> menuIterator = menu.createIterator();
                while (menuIterator.hasNext()) {
                    MenuComponent menuItem = menuIterator.next();
                    lunchItems.add(new MenuItemRecord(
                            menuItem.getName(),
                            menuItem.getDescription(),
                            menuItem.isVegetarian(),
                            menuItem.getPrice()
                    ));
                }
            }
        }

        return lunchItems;
    }

    public List<MenuItemRecord> getDinnerMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItemRecord> dinnerItems = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menu = iterator.next();
            if (menu instanceof CafeMenu) {
                Iterator<MenuComponent> menuIterator = menu.createIterator();
                while (menuIterator.hasNext()) {
                    MenuComponent menuItem = menuIterator.next();
                    dinnerItems.add(new MenuItemRecord(
                            menuItem.getName(),
                            menuItem.getDescription(),
                            menuItem.isVegetarian(),
                            menuItem.getPrice()
                    ));
                }
            }
        }

        return dinnerItems;
    }


}
