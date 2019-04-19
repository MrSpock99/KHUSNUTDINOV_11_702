package ru.itis.batmandbboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.WeaponAmmo;

public interface WeaponAmmoRepository extends JpaRepository<WeaponAmmo,Long> {
}
