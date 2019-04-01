package ru.itis.repositories;

import ru.itis.models.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByAlias(String alias);

    Optional<List<Subject>> getHeroes();

    Optional<List<Subject>> getVillains();

    List<Subject> findAllByAlias(String alias);
}
