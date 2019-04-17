package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "transport")
public class Transport extends BatmanThings {
    //Может плавать
    private boolean water;
    //Может летать
    private boolean air;
    //Может ездить
    private boolean ground;
}




