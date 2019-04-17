package ru.itis.batmandbboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.batmandbboot.models.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findOneByAlias(String alias);

    @Query(value = "SELECT * FROM subject WHERE TYPE = 1?", nativeQuery = true)
    Optional<List<Subject>> getAllHeroes(String type);

    @Query(value = "SELECT * FROM subject WHERE TYPE = 1?", nativeQuery = true)
    Optional<List<Subject>> getAllVillains(String type);

    List<Subject> findAllByAlias(String alias);
}
