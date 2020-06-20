package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.Repositories.RecipeRepository;
import guru.radugacode256.spring5webappv1.Repositories.UnitOfMeasureRepository;
import guru.radugacode256.spring5webappv1.commands.IngredientCommand;
import guru.radugacode256.spring5webappv1.converters.IngredientCommandToIngredient;
import guru.radugacode256.spring5webappv1.converters.IngredientToIngredientCommand;
import guru.radugacode256.spring5webappv1.model.Ingredient;
import guru.radugacode256.spring5webappv1.model.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

   private final IngredientToIngredientCommand ingredientToIngredientCommand;
   private final IngredientCommandToIngredient ingredientCommandToIngredient;
   private final RecipeRepository recipeRepository;
   private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if(!recipeOptional.isPresent()){
            //todo impl error handling
            log.error("recipe id not found. Id: "+recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> {
                    return ingredient.getId().equals(ingredientId);
                })
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()){
            //todo impl error handling
            log.error("Ingredient id is not found" + ingredientId);
        }

        return ingredientCommandOptional.get();
    }

    @Transactional
    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());

        if (!recipeOptional.isPresent()) {

            //todo toss error if not found!
            log.error("Recipe not found for Id: " + command.getRecipeId());
            return new IngredientCommand();
        } else {

            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> optionalIngredient = recipe
                    .getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            if (optionalIngredient.isPresent()) {

                Ingredient ingredientFound = optionalIngredient.get();
                ingredientFound.setDescriptions(command.getDescriptions());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUom(unitOfMeasureRepository
                        .findById(command.getUom().getId())
                        .orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); //todo address this
            } else {
                //add new Ingredient
                Ingredient ingredient = ingredientCommandToIngredient.convert(command);
                ingredient.setRecipe(recipe);
                recipe.addIngredients(ingredient);
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(ingredient -> ingredient.getId().equals(command.getId()))
                    .findFirst();

            //check by description
            if (!savedIngredientOptional.isPresent()){

                //not totally safe ... But best guess
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(ingredient -> ingredient.getDescriptions().equals(command.getDescriptions()))
                        .filter(ingredient -> ingredient.getAmount().equals(command.getAmount()))
                        .findFirst();
            }

            // todo check for fail
            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());
        }

    }

    @Override
    public void deleteById(Long recipeId, Long idToDelete) {

        log.debug("Dfeleting ingredient: "+ recipeId + ":" +idToDelete);

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isPresent()){

            Recipe recipe = recipeOptional.get();
            log.debug("found recipe");

            Optional<Ingredient> ingredientOptional = recipe.getIngredients()
                    .stream()
                    .filter(ingredient -> ingredient.getId().equals(idToDelete))
                    .findFirst();

            if (ingredientOptional.isPresent()){
                log.debug("found Ingredient");

                Ingredient ingredientToDelete = ingredientOptional.get();
                ingredientToDelete.setRecipe(null); //deleting from ingredient table
                recipe.getIngredients().remove(ingredientOptional.get());
                recipeRepository.save(recipe);

            }
        } else {
            log.debug("Recipe Id Not Found. Id: "+recipeId);
        }

    }
}
