package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.model.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);
}
