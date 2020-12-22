package application.repositories;

import db.models.StageResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageResultRepository extends CrudRepository<StageResult, Integer> {
}
