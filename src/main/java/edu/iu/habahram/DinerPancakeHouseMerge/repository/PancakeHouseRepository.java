package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class PancakeHouseRepository {
    public List<MenuItem> getTheMenu() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        return pancakeHouseMenu.getMenuItems();
    }

    public Iterator<MenuItem> createIterator() {
        return new PancakeMenuIterator(getTheMenu());
    }
}


