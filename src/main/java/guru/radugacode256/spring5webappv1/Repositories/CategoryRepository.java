package guru.radugacode256.spring5webappv1.Repositories;

import guru.radugacode256.spring5webappv1.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    //Am wondering why this is declared here and not in the service
    Optional<Category> findByDescription(String description);
}
