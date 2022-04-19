package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commads.NotesCommand;
import guru.springframework.spring5recipeapp.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    public Notes convert(NotesCommand source) {
        Notes notes = new Notes();
        if(source == null) {
            return null;
        }
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        notes.setRecipe(source.getRecipe());
        return notes;
    }
}
