package ru.itis;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car("ordinary car");
        Vehicle sportcar = new Sportcar("Sportcar");
        Vehicle plane = new Plane("Plane");
        Vehicle tank = new Tank("Tank");
        Vehicle tractorBelarus = new TractorBelarus("Tractor Belarus",125);

        Vehicle[] vehicles = {car,sportcar,plane,tank,tractorBelarus};

        showArray(vehicles);

        ParkingPlace parkingPlace = new ParkingPlace(1);

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
