package ru.itis;

public class TractorBelarus extends Vehicle {

    private int potatoesCount;

    TractorBelarus(String name,int fuelPerKm, int potatoesCount) {
        super(name,fuelPerKm);
        this.potatoesCount = potatoesCount;
    }

    public int getPotatoesCount() {
        return potatoesCount;
    }
}
