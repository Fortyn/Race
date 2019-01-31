package application.repositories;

import db.models.Right;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RightRepository extends CrudRepository<Right, Long> {
}
