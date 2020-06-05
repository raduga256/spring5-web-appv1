package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.NotesCommand;
import guru.radugacode256.spring5webappv1.model.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToCommandNotes  implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {

        if (notes != null ){

            final NotesCommand notesCommand = new NotesCommand();
            notesCommand.setId(notes.getId());
            notesCommand.setRecipeNotes(notes.getRecipeNotes());

            return notesCommand;
        }
        return null;
    }
}
