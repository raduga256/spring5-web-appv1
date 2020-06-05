package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.IngredientCommand;
import guru.radugacode256.spring5webappv1.model.Ingredient;
import guru.radugacode256.spring5webappv1.model.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {


    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {

        if (ingredientCommand == null){
            return null;
        }

        final Ingredient ingredient = new Ingredient();

        ingredient.setId(ingredientCommand.getId());
        //Setting the recipe by utilising a recipeId field used in the CommandObject in place for Recipe name. we check first for not null
        // then based on the result we can  now save/set the recipe into the ingredient.
        if (ingredientCommand.getRecipeId() != null){

            // Create an instance of the Recipe class and then pick recipeId from the CommObj and set to the instance
            // then add/set/save to our ingredients thus @ManyToOne
            // then add/set the said ingredient to a given recipe    thus @OneToMany bidirectional

            Recipe recipe = new Recipe();
            recipe.setId(ingredientCommand.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredients(ingredient);
        }

        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setDescriptions(ingredientCommand.getDescriptions());
        ingredient.setUom(ingredientCommand.getUom());

        return ingredient;
    }
}
