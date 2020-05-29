package guru.radugacode256.spring5webappv1.controllers;

import guru.radugacode256.spring5webappv1.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class IndexController {

//    private CategoryRepository categoryRepository;;
//    private UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({" ", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Loading Index page here");

//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//
//        System.out.println("Categoory ID is: "+categoryOptional.get().getId());
//        System.out.println("UnitOfMeaasure Id is: "+unitOfMeasureOptional.get().getId());
        log.debug("Getting Index page");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
