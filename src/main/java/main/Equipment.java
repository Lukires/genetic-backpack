package main;

public enum Equipment {
    KORT(90, 150), KOMPAS(130, 35), VAND(1530, 200), SANDWICH(500, 160),
    SUKKER(150,60), CANNEDFOOD(680, 45), BANAN(270, 60), APPLE(390, 40),
    OST(230, 30), BEER(520, 10), SOLCREME(110, 70), KAMERA(320, 30),
    TSHIRT(240, 15), BUKSER(480, 10), PARAPLY(730, 40), WATERPROOFPANTS(420, 70),
    WATERPROOFCLOTHES(430, 75), PUNG(220, 80), SOLBRILLER(70, 20), TOWEL(180, 12),
    SOKKER(40, 50), BOG(300, 10), NOTESBOG(900, 1), TELT(2000, 150);


    private int weight;
    private int value;
    Equipment(int weight, int value) {
        this.weight=weight;
        this.value=value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

}
