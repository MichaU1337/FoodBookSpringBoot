package com.mmierzwa.foodbook.controller;

import com.mmierzwa.foodbook.model.Recipe;
import com.mmierzwa.foodbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        List<Recipe> recipes = recipeService.findAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id){
        Recipe recipe = recipeService.findRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipeService.updateRecipe(recipe);
        return new ResponseEntity<>(updateRecipe,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id){
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>("Record #" + id + " has been deleted", HttpStatus.OK);
    }
}
