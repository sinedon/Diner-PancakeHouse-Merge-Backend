package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergerController {
    PancakeHouseRepository prepository;
    DinerRepository drepository;

    CafeRepository crepository;

    public MergerController(PancakeHouseRepository prepository, DinerRepository drepository, CafeRepository crepository) {
        this.drepository = drepository;
        this.prepository = prepository;
        this.crepository = crepository;
    }

    @GetMapping("/merger")
    public List<MenuItem> get() {
        List<MenuItem> mergedMenu = new ArrayList<>();

        Iterator<MenuItem> pancakeIterator = prepository.getTheMenuIterator();
        while (pancakeIterator.hasNext()) {
            mergedMenu.add(pancakeIterator.next());
        }

        Iterator<MenuItem> dinerIterator = drepository.getTheMenuIterator();
        while (dinerIterator.hasNext()) {
            mergedMenu.add(dinerIterator.next());
        }

        Iterator<MenuItem> cafeIterator = crepository.getTheMenuIterator();
        while (dinerIterator.hasNext()) {
            mergedMenu.add(cafeIterator.next());
        }

        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}
