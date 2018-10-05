package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Equipment extends BatmanThings {
    //Пуленепробиваемость
    private boolean bullet;
    //Неуязвимость против ножей
    private boolean knife;
    //Устойчивость к взрывам
    private boolean explosion;
}



