package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Data
@Entity(name = "weapon")
public class Weapon extends BatmanThings {
    /* @ManyToOne
     @JoinColumn(name = "ammo_id")*/
    @Transient
    private Ammo ammo;
}
