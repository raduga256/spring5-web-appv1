package guru.radugacode256.spring5webappv1.commands;

import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;
    private Long recipeId;
    private String descriptions;
    private BigDecimal amount;
    private UnitOfMeasure uom;

}
