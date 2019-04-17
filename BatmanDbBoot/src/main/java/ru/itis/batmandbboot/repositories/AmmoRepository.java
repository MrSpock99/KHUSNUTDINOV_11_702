package ru.itis.batmandbboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Ammo;

public interface AmmoRepository extends JpaRepository<Ammo, Long> {
}
