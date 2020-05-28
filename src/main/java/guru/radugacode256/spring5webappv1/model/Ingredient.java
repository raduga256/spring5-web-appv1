package guru.radugacode256.spring5webappv1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe", "uom"})
@Entity
public class Ingredient {
    public Ingredient(String descriptions, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.descriptions = descriptions;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptions;
    private BigDecimal amount;

    @OneToOne
    private UnitOfMeasure uom;

    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

}
