package com.mmierzwa.foodbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmierzwa.foodbook.controller.RecipeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


}
