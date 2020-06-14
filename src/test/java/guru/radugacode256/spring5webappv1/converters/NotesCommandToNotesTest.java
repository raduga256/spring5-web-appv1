package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.NotesCommand;
import guru.radugacode256.spring5webappv1.model.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = 1L;
    public  static final String recipeNotes = "We have a family motto";

    NotesCommandToNotes commandToNotes;

    @Before
    public void setUp() throws Exception {
        commandToNotes = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() {
        commandToNotes.convert(null);
    }

    @Test
    public void testNonEmptyObject() {
        commandToNotes.convert(new NotesCommand());
    }

    @Test
    public void convert() {
        //given
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(recipeNotes);

        //when
        Notes notes = commandToNotes.convert(command);

        //then
        assertNotNull(command);
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(recipeNotes, notes.getRecipeNotes());
    }
}