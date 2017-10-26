package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private int num;
    private int count = 0;
    private Vehicle[] vehicles = new Vehicle[10];
    private LocalTime beginTime = LocalTime.parse("07:00:00");
    private LocalTime finishTime = LocalTime.parse("22:00:00");

    public Vehicle[] getVehicles(){
        return vehicles;
    }
    ParkingPlace(int num){
        this.num = num;
    }

    private void putVehicle(Vehicle car){
        for (int i = 0; i < vehicles.length; i++){
            if (vehicles[i] == null){
                vehicles[i] = car;
                break;
            }
        }
        count++;

    }

    void letIn(Vehicle vehicle) {
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime)) {
            if (count <= vehicles.length - 1) {
                putVehicle(vehicle);
            } else {
                Vehicle[] newVehicles = new Car[vehicles.length * 2];
                for (int i = 0; i < vehicles.length; i++) {
                    newVehicles[i] = vehicles[i];
                }
                vehicles = null;//Лишнее?
                vehicles = newVehicles;
                putVehicle(vehicle);
            }

            System.out.println(vehicle + " drove in");
        } else {
            System.out.println("Parking doesn't work");
        }
    }

    void letOut(Vehicle vehicle) {
        boolean vehicleWasHere = false;
        if (LocalTime.now().isAfter(beginTime) && LocalTime.now().isBefore(finishTime) || !LocalTime.now().isAfter(beginTime) && !LocalTime.now().isBefore(beginTime)) {
            for (int i = 0; i < vehicles.length; i++){
                if (vehicle.equals(vehicles[i])){
                    vehicles[i] = null;
                    count--;
                    System.out.println(vehicle + " drove out");
                    vehicleWasHere = true;
                    break;
                }

            }
            if (!vehicleWasHere){
                System.out.println(vehicle + " is not in " + this);

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
