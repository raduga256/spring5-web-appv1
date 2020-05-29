package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.Repositories.RecipeRepository;
import guru.radugacode256.spring5webappv1.model.Recipe;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }
    @Test
    public void getRecipesTest() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(4L);
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

//        when(recipeService.getRecipes()).thenReturn(recipesData);
//
//        Set<Recipe> recipes = recipeService.getRecipes();
//
//        assertEquals(recipes.size(), 1);
//        verify(recipeRepository, times(1)).findAll();
//        verify(recipeRepository, never()).findById(anyLong());

    }
}