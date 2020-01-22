package main;

import java.util.Comparator;

public class BackpackComparator implements Comparator<Backpack> {
    public int compare(Backpack a, Backpack b) {
        return b.getValue() < a.getValue()?-1:b.getValue()==a.getValue()?0:1;
    }
}
