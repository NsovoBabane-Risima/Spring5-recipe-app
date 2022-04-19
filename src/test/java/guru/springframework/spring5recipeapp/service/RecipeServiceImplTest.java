package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5recipeapp.model.Notes;
import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeRepository recipeRepository;
    Set<Recipe> recipesData = new HashSet();
    Long recipeId1 = 7L;
    Long recipeId2 = 7L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository,recipeCommandToRecipe,recipeToRecipeCommand);

        recipesData.add(Recipe.builder().id(recipeId1).description("Recipe for Fat Cakes").build());
        recipesData.add(Recipe.builder().id(recipeId2).description("Recipe for pap").build());
    }

    @Test
    void getRecipes() {

        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        Assertions.assertEquals(recipes.size(), recipesData.size());
    }

    @Test
    public void getRecipeByIdTest() {
        log.info("Testing recipes find by id service method");
        Recipe returnedOptional = recipesData.stream()
                .filter(x -> x.getId().equals(recipeId1))
                .collect(Collectors.toList()).get(0);
        Recipe returnedRecipe = recipeService.findById(recipeId1);
        when(recipeRepository.findById(recipeId1)).thenReturn(Optional.ofNullable(returnedOptional));
        Assertions.assertEquals(recipeId1, returnedRecipe.getId());


    }
}