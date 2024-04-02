package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Iterator;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergerController {
    PancakeHouseRepository prepository;
    DinerRepository drepository;

    public MergerController(PancakeHouseRepository prepository, DinerRepository drepository) {
        this.drepository = drepository;
        this.prepository = prepository;
    }

    @GetMapping("/merger")
    public List<MenuItem> get() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        // Iterate over PancakeHouse menu using iterator
        Iterator pancakeIterator = prepository.createIterator();
        while (pancakeIterator.hasNext()) {
            mergedMenu.add((MenuItem) pancakeIterator.next());
        }

        // Iterate over Diner menu using iterator
        Iterator dinerIterator = drepository.createIterator();
        while (dinerIterator.hasNext()) {
            mergedMenu.add((MenuItem) dinerIterator.next());
        }

        // Sort the merged menu by name
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}
