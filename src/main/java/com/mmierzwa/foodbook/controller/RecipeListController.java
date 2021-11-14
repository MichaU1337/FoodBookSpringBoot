package com.mmierzwa.foodbook.controller;

import com.mmierzwa.foodbook.model.Recipe;
import com.mmierzwa.foodbook.model.RecipeList;
import com.mmierzwa.foodbook.service.RecipeListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class RecipeListController {

    private final RecipeListService recipeListService;

    @GetMapping("/myrecipes")
    public ResponseEntity<List<Recipe>> showMyRecipes(@CurrentSecurityContext(expression = "authentication?.name") String username) {
        List<RecipeList> recipeList = recipeListService.listOfRecipes(username);
        List<Recipe> recipes = recipeList.stream().map(RecipeList::getRecipe).collect(Collectors.toList());
        System.out.println(recipes);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}