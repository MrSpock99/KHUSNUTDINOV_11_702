package ru.itis;

public class Car {
    private ParkingPlace parkingPlace;
    private int num;

    public Car(int num){
        this.num = num;
    }

    public ParkingPlace getParkingPlace() {
        return parkingPlace;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        if (parkingPlace != null) {
            this.parkingPlace = parkingPlace;
        }
    }

    public boolean in(ParkingPlace parkingPlace){
        Car[] cars = parkingPlace.getCars();
        for(Car car : cars){
            if (this.equals(car)){
                return true;
            }
        }
        return false;
    }

    public void driveIn(ParkingPlace parkingPlace){
        parkingPlace.letIn(this);
        if (this.in(parkingPlace)){
            setParkingPlace(parkingPlace);
            this.parkingPlace = parkingPlace;
        }
    }

    public void driveOut(){
        if (parkingPlace != null) {
            parkingPlace.letOut(this);
        }
    }

    @Override
    public String toString() {
        return "Car №" + num;
    }
}
