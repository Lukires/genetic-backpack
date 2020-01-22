package main;

import java.util.ArrayList;
import java.util.Random;

public class Backpack {

    public ArrayList<Equipment> inventory;


    //Init random packpack
    public Backpack() {
        initRandom();
    }

    //Init pre defined inventory
    public Backpack(ArrayList<Equipment> inventory) {

        this.inventory=inventory;

        //1% chance to randomize the defined backpack ;)
        if (Math.random() < 0.01) {
            initRandom();
        }

        if (getWeight() > 5000) {
            initRandom();
        }
    }

    private void initRandom() {
        inventory = new ArrayList<Equipment>();

        for (int i = 0; i < Equipment.values().length; i++) {
            if (Math.random() < 0.8) {
                inventory.add(Equipment.values()[i]);
            }
        }
        if (getWeight() > 5000) {
            initRandom();
        }
    }

    public int getWeight() {
        int weight = 0;
        for(Equipment equipment : inventory) {
            weight+=equipment.getWeight();
        }
        return weight;
    }

    public int getValue() {
        int value = 0;
        for(Equipment equipment : inventory) {
            value+=equipment.getValue();
        }

        return value;
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public ArrayList<Equipment> getInventory() {
        return inventory;
    }


    public static Equipment noneContainingItem(ArrayList<Equipment> equipment) {

        int random = new Random().nextInt(Equipment.values().length);
        Equipment equip = Equipment.values()[random];

        if (equipment.contains(equip)) {
            return noneContainingItem(equipment);
        }
        return equip;
    }

    public static Backpack combineBackpackAt(Backpack one, Backpack two, int index) {
        ArrayList<Equipment> newInventory = new ArrayList<Equipment>();

        for(int i = 0; i < one.getInventorySize(); i++) {
            if (i < index) {
                newInventory.add(two.getInventory().get(i));
            }else{
                if (newInventory.contains(one.getInventory().get(i)))
                {
                    newInventory.add(noneContainingItem(newInventory));
                }else {
                    newInventory.add(one.getInventory().get(i));
                }
            }
        }

        return new Backpack(newInventory);
    }



}
