package guru.radugacode256.spring5webappv1.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;
    private Long recipeId; //Rather than an actual RecipeCommand here we use an object Id to implement Observer Pattern @ManyToOne mappings
    private String descriptions;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;

}
