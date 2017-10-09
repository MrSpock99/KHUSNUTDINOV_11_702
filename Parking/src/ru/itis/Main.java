package ru.itis;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car(1);
        Car car2 = new Car(2);

        ParkingPlace parkingPlace1 = new ParkingPlace(1);
        ParkingPlace parkingPlace2 = new ParkingPlace(2);

        Car[] carsInParkingPlace1 = parkingPlace1.getCars();

        car1.driveIn(parkingPlace1);
        car2.driveIn(parkingPlace1);

        showArray(carsInParkingPlace1);

        Car car3 = new Car(3);

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
