package guru.radugacode256.spring5webappv1.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {

    private Long id;
    private String description;
   // private Set<Recipe> recipes = new HashSet<>();  This recipes field is not declared in the command because its of @ManyToMany
    // and set/add any recipe(s) to the categoryCommand object... @ManyToMany mapping are implemented thru foreign_key e.g recipeId

}
