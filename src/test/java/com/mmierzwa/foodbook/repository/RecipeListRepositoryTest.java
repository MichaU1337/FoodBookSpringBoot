package com.mmierzwa.foodbook.repository;

import com.mmierzwa.foodbook.model.AppUser;
import com.mmierzwa.foodbook.model.Recipe;
import com.mmierzwa.foodbook.model.RecipeList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class RecipeListRepositoryTest {

    @Autowired
    private RecipeListRepository repository;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void testAddOneRecipeItem(){
//        Recipe recipe = entityManager.find(Recipe.class, 51L);
//        AppUser user = entityManager.find(AppUser.class, 3L);
//
//        RecipeList recipeItem = new RecipeList();
//        recipeItem.setRecipe(recipe);
//        recipeItem.setUser(user);
//
//        RecipeList savedRecipeItem = repository.save(recipeItem);
//
//        assertTrue(savedRecipeItem.getId() > 0);
//    }

//    @Test
//    public void testGetRecipeItemByUser(){
//        AppUser appUser = new AppUser();
//        appUser.setEmail("mm@gmail.com");
//
//        List<RecipeList> userRecipes = repository.findByUser_Email(appUser.getEmail());
//        assertEquals(2,userRecipes.size());
//    }
}