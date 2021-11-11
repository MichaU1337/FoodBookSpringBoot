package com.mmierzwa.foodbook.service;

import com.mmierzwa.foodbook.model.AppUser;
import com.mmierzwa.foodbook.model.RecipeList;
import com.mmierzwa.foodbook.repository.RecipeListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeListService {

    private RecipeListRepository repository;

    public List<RecipeList> listOfRecipes(AppUser user){
        return repository.findByUser(user);
    }
}
