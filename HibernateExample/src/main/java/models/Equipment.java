package models;

import javax.persistence.Entity;

@Entity(name = "equipment")
public class Equipment extends BatmanThings {
    //Пуленепробиваемость
    private Boolean bullet;
    //Неуязвимость против ножей
    private Boolean knife;
    //Устойчивость к взрывам
    private Boolean explosion;
}



