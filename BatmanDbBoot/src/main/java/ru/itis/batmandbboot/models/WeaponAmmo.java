package ru.itis.batmandbboot.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "weapon_ammo")
public class WeaponAmmo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @OneToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
    @OneToOne
    @JoinColumn(name = "ammo_id")
    private Ammo ammo;
}
