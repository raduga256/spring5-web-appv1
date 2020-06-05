package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.RecipeCommand;
import guru.radugacode256.spring5webappv1.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConveter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToCommandNotes notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter, NotesToCommandNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {

        if (recipe == null){
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(recipe.getId());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setNotes(recipe.getNotes());
        if (recipe.getNotes() != null){
            recipeCommand.setNotes(recipe.getNotes());
        }

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0){
            recipe.getCategories()
                    .forEach((category) -> recipeCommand.getCategories().add(category));
        }

        if (recipe.getIngredients() != null && recipe.getIngredients().size() > 0){
            recipe.getIngredients()
                    .forEach(ingredient -> recipeCommand.getIngredients().add(ingredient));
        }

        return recipeCommand;
    }
}
