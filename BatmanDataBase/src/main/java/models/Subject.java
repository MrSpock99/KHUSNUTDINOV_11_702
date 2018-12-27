package models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Subject {
    private Long id;
    //Вымышленное имя
    private String alias;
    //Реальное имя
    private String realName;
    //Какое оружие против него использовать
    private Weapon weakness;
    //Какую костюм надеть при битве с ним
    private Equipment defence;
    //Злодей или герой
    private SubjectType type;
    //Изображение
    private String imageBase64;
}

