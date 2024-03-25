package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@RestController
public class MergerController {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public MergerController(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    @GetMapping("/merger")
    public List<MenuItem> get() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        // Iterate over PancakeHouse menu
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        while (pancakeIterator.hasNext()) {
            mergedMenu.add(pancakeIterator.next());
        }

        // Iterate over Diner menu
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        while (dinerIterator.hasNext()) {
            mergedMenu.add(dinerIterator.next());
        }

        // Sort the merged menu by name
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}



