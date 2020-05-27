package guru.radugacode256.spring5webappv1.Repositories;

import guru.radugacode256.spring5webappv1.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {


    Optional<Category> findByDescription(String description);
}
