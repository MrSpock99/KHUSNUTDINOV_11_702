package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "expense")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    //Оружие, боеприпасы, транспорт, броня
    @Column(length = 20)
    private String type;
    private Integer amount;
    private Integer cost;
    private Long budget;
}

