package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private static int num;
    private int count = 0;
    private Car[] cars = new Car[10];
    private LocalTime beginTime = LocalTime.parse("07:00:00");
    private LocalTime finishTime = LocalTime.parse("23:00:00");

    public Car[] getCars(){
        return cars;
    }
    public ParkingPlace(){
        num++;
    }

    void putCar(Car car){
        for (int i = 0; i < cars.length; i++){
            if (cars[i] == null){
                cars[i] = car;
                break;
            }
        }
        count++;

    }

    public void letIn(Car car) {
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            if (count <= cars.length - 1) {
                putCar(car);
            } else {
                Car[] newCars = new Car[cars.length * 2];
                for (int i = 0; i < cars.length; i++) {
                    newCars[i] = cars[i];
                }
                cars = null;//Лишнее?
                cars = newCars;
                putCar(car);
            }

            System.out.println(car + " drove in");
        } else {
            System.out.println("Parking doesn't work");
        }
    }

    public void letOut(Car car) {
        boolean carWasHere = false;
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            for (int i = 0; i < cars.length; i++){
                if (car.equals(cars[i])){
                    cars[i] = null;
                    count--;
                    System.out.println(car + " drove out");
                    carWasHere = true;
                    break;
                }

            }
            if (!carWasHere){
                System.out.println(car + " is not in " + this);

            }

        } else {
            System.out.println("Parking doesn't work");

        }
    }

    @Override
    public String toString() {
        return "Parking №" + num;
    }
}
