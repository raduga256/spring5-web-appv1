package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.IngredientCommand;
import guru.radugacode256.spring5webappv1.model.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {

        if (ingredient == null){
            return null;
        }

        final IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(ingredient.getId());

        //first check to see that a certain recipe does exist before you can set CommObj recipe by Id
        if (ingredient.getRecipe() != null){
            ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        }
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescriptions(ingredient.getDescriptions());
        ingredientCommand.setUom(ingredient.getUom());

        return ingredientCommand;
    }
}
