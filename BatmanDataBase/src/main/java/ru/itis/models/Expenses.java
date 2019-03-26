package ru.itis.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expenses {
    private Long id;
    private String name;
    //Оружие, боеприпасы, транспорт, броня
    private String type;
    private Integer amount;
    private Integer cost;
    private Long budget;
}

