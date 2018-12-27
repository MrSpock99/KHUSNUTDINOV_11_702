package models;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends BatmanThings {
    //Пуленепробиваемость
    private Boolean bullet;
    //Неуязвимость против ножей
    private Boolean knife;
    //Устойчивость к взрывам
    private Boolean explosion;
}



