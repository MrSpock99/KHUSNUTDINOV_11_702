package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Expenses {
    private Long id;
    private String name;
    //Оружие, боеприпасы, транспорт, броня
    private BatmanThings type;
    private int amount;
    private int cost;
}

