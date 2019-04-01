package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "weapon")
public class Weapon extends BatmanThings {
    @ManyToOne
    @JoinColumn(name = "ammo_id")
    private Ammo ammo;
}
