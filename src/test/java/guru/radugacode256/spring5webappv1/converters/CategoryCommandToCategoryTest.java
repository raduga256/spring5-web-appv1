package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.CategoryCommand;
import guru.radugacode256.spring5webappv1.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "American";

    CategoryCommandToCategory commandToCategory;

    @Before
    public void setUp() throws Exception {
        commandToCategory = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() {
        assertNull(commandToCategory.convert(null));
    }

    @Test
    public void testNonEmptyObject() {
        assertNotNull(commandToCategory.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = commandToCategory.convert(categoryCommand);

        //then
        assertNotNull(categoryCommand);
        assertNotNull(category);
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());

    }
}