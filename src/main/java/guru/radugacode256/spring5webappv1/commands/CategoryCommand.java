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
   // private Set<Recipe> recipes = new HashSet<>();  We should introduce a recipeId check if its not null then use it to go ahead
    // and set/add any recipe(s) to the categoryCommand object... @ManyToMany mapping are implemented thru foreign_key e.g recipeId

}
