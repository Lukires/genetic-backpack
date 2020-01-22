package main;

import processing.core.PApplet;

public class Main extends PApplet {

    Population population = new Population();

    public static void main(String[] args){
        PApplet.main("main.Main");
    }

    public void settings() {
        size(1400,300);
    }

    public void setup() {
        frameRate(30);
    }

    int highest = 0;
    String topPop;
    int bestGen = 0;
    int generation = 0;

    public void draw() {

        generation++;
        if (population.topValue() > highest) {
            highest = population.topValue();
            bestGen = generation;
            topPop = population.getBackpack(0).getInventory().toString();
        }
        background(255);
        fill(0);

        //BEDSTE
        textSize(32);
        text("Bedste værdi ("+bestGen+") :"+highest, 20,100);
        textSize(12);
        text("Bedste ting: "+topPop, 20, 150, 300, 300);

        //NUVÆRENDE
        textSize(32);
        text("Nuværende værdi ("+generation+") :"+population.topValue(), 450,   100);
        textSize(12);
        text("Nuværende ting: "+population.getBackpack(0).getInventory().toString(), 450, 150, 300, 300);
        population.repopulate(new StrongestRepopulation());
    }
}
