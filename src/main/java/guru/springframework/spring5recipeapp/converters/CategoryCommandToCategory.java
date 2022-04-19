package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commads.CategoryCommand;
import guru.springframework.spring5recipeapp.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Override
    public Category convert(CategoryCommand source) {
        final Category category = new Category();
        if (source == null) {
            return null;
        }
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
