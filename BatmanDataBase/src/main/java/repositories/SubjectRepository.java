package repositories;

import models.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByAlias(String alias);

    Optional<List<Subject>> getHeroes();

    Optional<List<Subject>> getVillains();
}
