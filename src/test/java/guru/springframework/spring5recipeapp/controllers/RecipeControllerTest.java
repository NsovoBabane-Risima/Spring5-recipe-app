package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.model.Recipe;
import guru.springframework.spring5recipeapp.service.RecipeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@ExtendWith(SpringExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeService recipeService;
    @InjectMocks
    RecipeController controller;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new RecipeController(recipeService);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    void getRecipeByIdTest() throws Exception {
        Long recipeId = 7L;
        Recipe recipe = Recipe.builder().id(recipeId).description("Test Recipe").build();
        Mockito.when(recipeService.findById(recipeId)).thenReturn(recipe);
        mockMvc.perform(get("/recipe/show/" + recipeId))
                .andExpect(status().isOk())
                .andExpect(view().name("/recipe/show"))
                .andExpect(model().attribute("recipe",
                        Matchers.hasProperty("id", Matchers.is(recipeId))));
    }
}