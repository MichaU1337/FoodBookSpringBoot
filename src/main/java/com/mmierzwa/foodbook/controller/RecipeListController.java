package com.mmierzwa.foodbook.controller;

import com.mmierzwa.foodbook.service.AppUserService;
import com.mmierzwa.foodbook.service.RecipeListService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeListController {

    private RecipeListService recipeListService;
    private AppUserService userService;

    @GetMapping("/myrecipes")
    public String showMyRecipes(@CurrentSecurityContext(expression = "authentication?.name") String username) {
        System.out.println(username);
        return username;
    }
}
