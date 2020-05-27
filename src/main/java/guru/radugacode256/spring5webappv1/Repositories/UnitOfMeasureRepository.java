package guru.radugacode256.spring5webappv1.Repositories;

import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long > {

    Optional<UnitOfMeasure> findByDescription(String  description);
}
