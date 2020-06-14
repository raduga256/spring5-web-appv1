package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.CategoryCommand;
import guru.radugacode256.spring5webappv1.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "American";

    CategoryToCategoryCommand categoryToCategoryCommand;

    @Before
    public void setUp() throws Exception {

        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void testNonEmptyObject() {
        assertNotNull(categoryToCategoryCommand.convert(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand command = categoryToCategoryCommand.convert(category);

        //then
        assertNotNull(category);
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());

    }
}