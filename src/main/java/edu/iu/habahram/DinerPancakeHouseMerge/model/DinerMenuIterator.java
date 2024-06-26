package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.NoSuchElementException;
import java.util.Iterator;
public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] list;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.list = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < list.length && list[position] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator");
        }
        return list[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }

        if (list[position -1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[i+1];
            }
            list[list.length - 1] = null;
        }
    }
}
