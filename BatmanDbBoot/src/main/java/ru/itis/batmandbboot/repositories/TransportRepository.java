package ru.itis.batmandbboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long> {
}
