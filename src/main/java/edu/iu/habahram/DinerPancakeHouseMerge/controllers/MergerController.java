package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
public class MergerController {
    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }
    @GetMapping
    public List<MenuItemRecord> get() {
        return mergerRepository.getTheMenuItems();
    }
    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegItems() {
        return mergerRepository.getVegetarianMenuItems();
    }
    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        return mergerRepository.getBreakfastMenuItems();
    }
    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        return mergerRepository.getLunchMenuItems();
    }
    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperItems() {
        return mergerRepository.getDinnerMenuItems();
    }
}
