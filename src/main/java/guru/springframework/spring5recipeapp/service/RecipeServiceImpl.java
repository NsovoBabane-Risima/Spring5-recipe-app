package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Iterable<Recipe> recipeIterator = recipeRepository.findAll();
        List<Recipe> recipeList = new ArrayList<>();

        recipeIterator.forEach(element -> recipeList.add(element));

        return recipeList;
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
