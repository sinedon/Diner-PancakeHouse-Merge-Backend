package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class PancakeMenuIterator implements Iterator<MenuItem> {
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
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }

        list.remove(position - 1);
        position--;
    }
}
