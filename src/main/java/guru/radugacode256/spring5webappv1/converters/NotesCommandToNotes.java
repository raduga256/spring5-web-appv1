package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.NotesCommand;
import guru.radugacode256.spring5webappv1.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {

        if (notesCommand != null){

            final Notes notes = new Notes();
            notes.setId(notesCommand.getId());
            notes.setRecipeNotes(notesCommand.getRecipeNotes());

            return notes;
        }

        return null;
    }

}
