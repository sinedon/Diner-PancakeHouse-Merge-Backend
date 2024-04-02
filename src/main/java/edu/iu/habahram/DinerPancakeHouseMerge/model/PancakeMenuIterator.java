package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.List;
import java.util.NoSuchElementException;

public class PancakeMenuIterator implements Iterator {
    List<MenuItem> list;
    int position = 0;

    public PancakeMenuIterator(List<MenuItem> menuItems) {
        this.list = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator");
        }
        return list.get(position++);
    }
}
