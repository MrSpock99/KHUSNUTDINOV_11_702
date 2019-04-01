package models;

import javax.persistence.Entity;

@Entity(name = "transport")
public class Transport extends BatmanThings {
    //Может плавать
    private boolean water;
    //Может летать
    private boolean air;
    //Может ездить
    private boolean ground;
}




