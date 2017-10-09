package ru.itis;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingPlace parkingPlace1 = new ParkingPlace();
        ParkingPlace parkingPlace2 = new ParkingPlace();

        Car[] carsInParkingPlace1 = parkingPlace1.getCars();

        car1.driveIn(parkingPlace1);
        car2.driveIn(parkingPlace1);

        showArray(carsInParkingPlace1);

        Car car3 = new Car();

        car2.driveOut();
        car3.driveIn(parkingPlace1);

        showArray(carsInParkingPlace1);


        car1.driveOut();
        car2.driveOut();

        showArray(carsInParkingPlace1);

        car1.driveIn(parkingPlace1);

        showArray(carsInParkingPlace1);


    }

    static void showArray(Car[] cars){
        for (Car item : cars){
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}
