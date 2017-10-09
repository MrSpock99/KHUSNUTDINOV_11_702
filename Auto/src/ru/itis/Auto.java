package ru.itis;

public class Auto {
    private String model;
    private String num;
    private int power;
    private String colour;
    private int mileage;

    public Auto(){

    }

    public Auto(String model, int power){
        setModel(model);
        setPower(power);
    }

    public Auto(String model, String num, int power, String colour){
        setModel(model);
        setPower(power);
        setNum(num);
        setColour(colour);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (!model.equals("")){
            this.model = model;
        }else {
            this.model = "DEFAULT_MODEL";
            System.out.println("Неверное значение\nУстановлено значение по умолчанию");
        }
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        if (!num.equals("")){
            this.num = num;
        }else {
            this.num = "DEFAULT_NUM";
            System.out.println("Неверное значение\nУстановлено значение по умолчанию");

        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power >= 0){
            this.power = power;
        }else {
            System.out.println("Неверное значение\nУстановлено значение по умолчанию");
            this.power = 0;
        }
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if (!colour.equals("")){
            this.colour = colour;
        }else {
            this.colour = "DEFAULT_POWER";
            System.out.println("Неверное значение\nУстановлено значение по умолчанию");

        }
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (mileage >= 0){
            this.mileage = mileage;
        }else {
            this.mileage = 0;
            System.out.println("Неверное значение\nУстановлено значение по умолчанию");

        }
    }

    public void go(int km){
        System.out.println("Проехал " + km + " km");
        mileage += km;
    }
}
