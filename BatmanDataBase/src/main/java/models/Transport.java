package models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Transport extends BatmanThings {
    //Может плавать
    private boolean water;
    //Может летать
    private boolean air;
    //Может ездить
    private boolean ground;
}




