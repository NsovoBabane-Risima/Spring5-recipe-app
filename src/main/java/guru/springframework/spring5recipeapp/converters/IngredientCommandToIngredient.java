package guru.springframework.spring5recipeapp.converters;

import guru.springframework.spring5recipeapp.commads.IngredientCommand;
import guru.springframework.spring5recipeapp.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }

    @Override
    public Ingredient convert(IngredientCommand source) {
        final Ingredient ingredient = new Ingredient();
        if (source == null) {
            return null;
        }
        ingredient.setId(source.getId());
        ingredient.setUom(unitOfMeasureCommandToUnitOfMeasure
                .convert(source.getUom()));
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        return ingredient;
    }
}
