package repositories;

import models.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    Subject findByAlias(String alias);
}
