package main;

import java.util.ArrayList;
import java.util.Random;

public class StrongestRepopulation implements Repopulation<Population> {
    public void repopulateAt(Population population, int index) {

        ArrayList<Backpack> backpacks = new ArrayList<Backpack>();
        for (int i = 0; i<population.size; i++) {
            Backpack primary = population.getBackpack(i);

            int random = new Random().nextInt(index);
            Backpack secondary = population.getBackpack(random);

            int limit = primary.getInventorySize() < secondary.getInventorySize()? primary.getInventorySize() : secondary.getInventorySize();
            random = new Random().nextInt(limit);

            backpacks.add(Backpack.combineBackpackAt(primary, secondary, random));
        }

        population.setNewGeneration(backpacks);

    }
}
