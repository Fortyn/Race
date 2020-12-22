package application.repositories;

import db.models.StageQualification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageQualificationRepository extends CrudRepository<StageQualification, Integer> {
}
