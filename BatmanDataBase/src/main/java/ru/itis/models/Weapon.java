package ru.itis.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weapon extends BatmanThings {
    private Ammo ammo;
}

