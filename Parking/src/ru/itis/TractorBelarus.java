package ru.itis;

public class TractorBelarus extends Vehicle {

    private int potatoesCount;

    TractorBelarus(String name, int potatoesCount) {
        super(name);
        this.potatoesCount = potatoesCount;
    }

    public int getPotatoesCount() {
        return potatoesCount;
    }
}
