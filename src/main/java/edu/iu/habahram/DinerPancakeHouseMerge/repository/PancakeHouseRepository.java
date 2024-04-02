package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PancakeHouseRepository implements Iterable<MenuItem> {
    private MenuItem[] menuItems;

    public PancakeHouseRepository() {
        // Initialize menu items (replace this with your actual initialization logic)
        this.menuItems = new MenuItem[] {
                new MenuItem("Pancake", "Delicious pancake", 5.99),
                new MenuItem("Waffle", "Yummy waffle", 6.49),
                new MenuItem("French Toast", "Tasty french toast", 4.99)
        };
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new PancakeHouseIterator();
    }

    private class PancakeHouseIterator implements Iterator<MenuItem> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < menuItems.length;
        }

        @Override
        public MenuItem next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the iterator");
            }
            return menuItems[position++];
        }
    }

    public Iterator createIterator() {
        return new PancakeMenuIterator(getTheMenu());
    }
}

