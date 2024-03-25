package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
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

        // Iterate over PancakeHouse menu
        for (MenuItem item : prepository) {
            mergedMenu.add(item);
        }

        // Iterate over Diner menu
        for (MenuItem item : drepository.getTheMenu()) {
            mergedMenu.add(item);
        }

        // Sort the merged menu by name
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}

