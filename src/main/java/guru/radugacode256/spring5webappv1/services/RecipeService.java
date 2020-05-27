package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {
    Set<Recipe> getRecipes();
}
