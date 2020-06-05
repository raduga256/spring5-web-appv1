package guru.radugacode256.spring5webappv1.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
   // private Recipe recipe; Should not be displayed under list notes/show
    private String recipeNotes;
}
