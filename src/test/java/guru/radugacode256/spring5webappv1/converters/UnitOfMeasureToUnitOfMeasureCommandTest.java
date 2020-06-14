package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.UnitOfMeasureCommand;
import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    UnitOfMeasureToUnitOfMeasureCommand toUnitOfMeasureCommand;

    @Before
    public void setUp() throws Exception {
        toUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(toUnitOfMeasureCommand.convert(null));
    }

    @Test
    public void testNonNullObject() {
        assertNotNull(toUnitOfMeasureCommand.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand command = toUnitOfMeasureCommand.convert(unitOfMeasure);

        //then
        assertNotNull(unitOfMeasure);
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}