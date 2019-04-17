package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "ammo")
public class Ammo extends BatmanThings {
}
