package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.NoSuchElementException;

public class DinerMenuIterator implements Iterator {
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
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator");
        }
        return list[position++];
    }
}
