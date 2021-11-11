package com.mmierzwa.foodbook.repository;

import com.mmierzwa.foodbook.model.AppUser;
import com.mmierzwa.foodbook.model.RecipeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeListRepository extends JpaRepository<RecipeList, Long> {

    List<RecipeList> findByUser(AppUser appUser);
}
