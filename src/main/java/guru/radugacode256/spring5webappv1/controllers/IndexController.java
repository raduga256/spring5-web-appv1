package guru.radugacode256.spring5webappv1.controllers;

import guru.radugacode256.spring5webappv1.Repositories.CategoryRepository;
import guru.radugacode256.spring5webappv1.Repositories.UnitOfMeasureRepository;
import guru.radugacode256.spring5webappv1.model.Category;
import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({" ", " /", "/index"})
    public String getIndexPage(Model model){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Categoory ID is: "+categoryOptional.get().getId());
        System.out.println("UnitOfMeaasure Id is: "+unitOfMeasureOptional.get().getId());

        return "index";
    }
}
