package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.Repositories.RecipeRepository;
import guru.radugacode256.spring5webappv1.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class RecipeServiceImplTest {
    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Test
    public void getRecipes() throws Exception{

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());

    }

    @Test
    public void getRecipesById() throws Exception{

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned );
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }
    //todo create test for findCommandById method

    @Test
    public void testDeleteById(){

        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);

        // no 'when', since the method has void return type

        //then
        verify(recipeRepository, times(1)).deleteById(idToDelete);
    }
}