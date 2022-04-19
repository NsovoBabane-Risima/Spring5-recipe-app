package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.commads.RecipeCommand;
import guru.springframework.spring5recipeapp.model.Recipe;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long recipeId1);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long id);

    void deleteCommandById(Long valueOf);
}
