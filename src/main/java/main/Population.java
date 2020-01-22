package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Population {

    private ArrayList<Backpack> backpacks = new ArrayList<Backpack>();
    int generation = 0;
    int size = 0;

    //Initialize population
    public Population() {
        populate(2500);
    }

    //Populate
    public void populate(int size) {
        this.size=size;
        for (int i = 0; i < size; i++) {
            backpacks.add(new Backpack());
        }
    }

    public void repopulate(Repopulation<Population> repopulationType) {
        sort();
        int random = new Random().nextInt(((int)(size/4)))+1;
        repopulationType.repopulateAt(this, random);
    }

    public Backpack getBackpack(int index) {
        return backpacks.get(index);
    }

    public void setNewGeneration(ArrayList<Backpack> backpacks) {
        this.backpacks=backpacks;
        generation++;
    }

    //Sort the backpacks by their value
    public void sort() {
        Collections.sort(backpacks, new BackpackComparator());
    }

    public int topValue() {
        sort();
        return backpacks.get(0).getValue();
    }

    public int topWeight() {
        sort();
        return backpacks.get(0).getWeight();
    }
}
