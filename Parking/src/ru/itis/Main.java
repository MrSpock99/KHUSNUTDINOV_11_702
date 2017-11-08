package ru.itis;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car("ordinary car",2);
        Vehicle sportcar = new Sportcar("Sportcar",5);
        Vehicle plane = new Plane("Plane",10);
        Vehicle tank = new Tank("Tank",7);
        Vehicle tractorBelarus = new TractorBelarus("Tractor Belarus",999,125);

        Vehicle[] vehicles = {car,sportcar,plane,tank,tractorBelarus};

        showArray(vehicles);

        ParkingPlace parkingPlace = new ParkingPlace(1);
        System.out.println(parkingPlace);

        car.driveIn(parkingPlace);
        sportcar.driveIn(parkingPlace);
        tractorBelarus.driveIn(parkingPlace);
        plane.driveIn(parkingPlace);
        tank.driveIn(parkingPlace);

        Vehicle[] vehiclesInParking = parkingPlace.getVehicles();

        tank.driveOut();

        showArray(vehiclesInParking);
    }

    static void showArray(Vehicle[] vehicles){
        for (Vehicle item : vehicles){
            System.out.print(item + "|");
        }
        System.out.println("");
    }
}
