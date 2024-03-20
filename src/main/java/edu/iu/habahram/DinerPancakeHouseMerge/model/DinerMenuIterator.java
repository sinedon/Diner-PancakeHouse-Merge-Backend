package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class DinerMenuIterator implements Iterator{
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.length || (menuItems[position] == null)) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }
}
