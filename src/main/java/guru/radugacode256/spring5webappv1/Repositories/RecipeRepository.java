package guru.radugacode256.spring5webappv1.Repositories;

import guru.radugacode256.spring5webappv1.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
