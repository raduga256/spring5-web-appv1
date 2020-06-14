package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.IngredientCommand;
import guru.radugacode256.spring5webappv1.model.Ingredient;
import guru.radugacode256.spring5webappv1.model.Recipe;
import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final String DESCRIPTION = "CheeseBurger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testNonEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() {

        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescriptions(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        //when
        IngredientCommand command =  converter.convert(ingredient);

        //then
        assertNotNull(ingredient);
        assertNotNull(uom);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescriptions());
        assertEquals(UOM_ID, command.getUom().getId());

    }

    @Test
    public void convertWithNullUOM(){
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescriptions(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertNotNull(ingredient);
        assertEquals(null, ingredient.getUom());
        assertEquals(ID_VALUE, command.getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescriptions());

    }
}