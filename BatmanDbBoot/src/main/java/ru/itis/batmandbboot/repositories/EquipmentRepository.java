package ru.itis.batmandbboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
