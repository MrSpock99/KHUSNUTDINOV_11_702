package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "equipment")
public class Equipment extends BatmanThings {
    //Пуленепробиваемость
    private Boolean bullet;
    //Неуязвимость против ножей
    private Boolean knife;
    //Устойчивость к взрывам
    private Boolean explosion;
}



