package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commads.NotesCommand;
import guru.springframework.spring5recipeapp.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        notesCommand.setRecipe(source.getRecipe());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
