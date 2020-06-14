package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.NotesCommand;
import guru.radugacode256.spring5webappv1.model.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToCommandNotesTest {

    public static final Long ID_VALUE = 1L;
    public  static final String recipeNotes = "We have a family motto";

    NotesToCommandNotes toCommandNotes;

    @Before
    public void setUp() throws Exception {
        toCommandNotes = new NotesToCommandNotes();
    }

    @Test
    public void testNullObject() {
        assertNull(toCommandNotes.convert(null));
    }

    @Test
    public void testNonEmptyObject() {
        assertNotNull(toCommandNotes.convert(new Notes()));
    }

    @Test
    public void convert() {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(recipeNotes);

        //when
        NotesCommand command = toCommandNotes.convert(notes);

        //given
        assertNotNull(notes);
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(recipeNotes, command.getRecipeNotes());

    }
}