package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Expenses {
    private Long id;
    private String name;
    //Оружие, боеприпасы, транспорт, броня
    private String type;
    private Integer amount;
    private Integer cost;
    private Long budget;
}

