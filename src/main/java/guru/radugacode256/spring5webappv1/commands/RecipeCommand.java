package guru.radugacode256.spring5webappv1.commands;

import guru.radugacode256.spring5webappv1.model.Category;
import guru.radugacode256.spring5webappv1.model.Difficulty;
import guru.radugacode256.spring5webappv1.model.Ingredient;
import guru.radugacode256.spring5webappv1.model.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private  String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private Notes notes;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
}
