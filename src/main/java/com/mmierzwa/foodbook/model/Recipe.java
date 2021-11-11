package com.mmierzwa.foodbook.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String author;
    private String descriptionShort;
    private String descriptionLong;
    private String category;
    private String pictureMain;
    private String pictureMini;

    @Min(0L)
    @Max(5L)
    private int difficulty;

    @Min(0L)
    private int servings;

    // TODO: Figure out how to add a Map<String,String> using JPA to MYSQL
    // https://www.baeldung.com/hibernate-persisting-maps
    // example code how to do it

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "ingredients", joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "ingredient")
//    @Column(name = "ingredient_quantity")
//    private Map<String, String> ingredients = new HashMap<String, String>();
}
