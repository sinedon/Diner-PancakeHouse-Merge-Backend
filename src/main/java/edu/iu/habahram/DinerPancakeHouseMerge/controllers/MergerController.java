package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
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

        MergerRepository mergerRepository = new MergerRepository();
        ArrayList<Menu> menus = mergerRepository.getTheMenus();

        for (Menu menu : menus) {
            Iterator<MenuItem> menuIterator = menu.createIterator();
            while (menuIterator.hasNext()) {
                mergedMenu.add(menuIterator.next());
            }
        }

        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}
