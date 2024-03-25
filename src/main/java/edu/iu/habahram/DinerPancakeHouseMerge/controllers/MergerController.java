package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
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

        mergedMenu.addAll(prepository.getTheMenu());

        for (MenuItem item : drepository.getTheMenu()) {
            mergedMenu.add(item);
        }
        
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}
