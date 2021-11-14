package com.mmierzwa.foodbook.service;

import com.mmierzwa.foodbook.model.RecipeList;
import com.mmierzwa.foodbook.repository.RecipeListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeListService {

    private final RecipeListRepository repository;

    public List<RecipeList> listOfRecipes(String userEmail){
        return repository.findByUser_Email(userEmail);
    }
}
