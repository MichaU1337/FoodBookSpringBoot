package com.mmierzwa.foodbook.controller;

import com.mmierzwa.foodbook.exception.ResourceNotFoundException;
import com.mmierzwa.foodbook.model.Recipe;
import com.mmierzwa.foodbook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable(value = "id") Long recipeId,
       @Valid @RequestBody Recipe recipe) {

        Recipe editedRecipe = recipeService.findRecipeById(recipeId);
        editedRecipe.setCategory(recipe.getCategory());
        editedRecipe.setDescription(recipe.getDescription());
        editedRecipe.setDescriptionSummary(recipe.getDescriptionSummary());
        editedRecipe.setName(recipe.getName());
        editedRecipe.setServings(recipe.getServings());
        editedRecipe.setStars(recipe.getStars());

        final Recipe updatedRecipe = recipeService.updateRecipe(editedRecipe);
        return ResponseEntity.ok(updatedRecipe);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id ){
        if(recipeService.findRecipeById(id).getId() == id){
            recipeService.deleteRecipe(id);
        }
        else throw new ResourceNotFoundException("There is no record with the Id you have provided: " + id);

        return new ResponseEntity<>("record #" + id + " has been deleted", HttpStatus.OK);
    }
}
