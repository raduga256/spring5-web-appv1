package guru.radugacode256.spring5webappv1.controllers;

import guru.radugacode256.spring5webappv1.commands.IngredientCommand;
import guru.radugacode256.spring5webappv1.commands.RecipeCommand;
import guru.radugacode256.spring5webappv1.commands.UnitOfMeasureCommand;
import guru.radugacode256.spring5webappv1.services.IngredientService;
import guru.radugacode256.spring5webappv1.services.RecipeService;
import guru.radugacode256.spring5webappv1.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        log.debug("Getting Ingredient list for recipe Id: "+recipeId);

        //use command object to avoid lazy load errors in Thymeleaf.
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipe(@PathVariable String recipeId, Model model){

        //make sure we have a good id value
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        //todo raise exception if null

        //need to return back parent id for hidden form property
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);

        //init uom
        ingredientCommand.setUom(new UnitOfMeasureCommand());

        model.addAttribute("uomList", unitOfMeasureService.listAllUom());

        return "recipe/ingredient/ingredientform";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                 @PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String ingredientId, Model model){

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        model.addAttribute("uomList", unitOfMeasureService.listAllUom());

        return "recipe/ingredient/ingredientform";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient")
    public String saveorUpdate(IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved recipe Id : "+savedCommand.getRecipeId());
        log.debug("saved ingredient Id : "+savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
