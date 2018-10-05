package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Transport extends BatmanThings {
    //Может плавать
    private boolean water;
    //Может летать
    private boolean air;
    //Может ездить
    private boolean ground;
}




