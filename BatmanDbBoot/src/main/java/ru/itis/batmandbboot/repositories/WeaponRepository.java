package ru.itis.batmandbboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
