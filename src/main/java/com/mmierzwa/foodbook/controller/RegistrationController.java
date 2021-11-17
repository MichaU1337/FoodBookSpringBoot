package com.mmierzwa.foodbook.controller;

import com.mmierzwa.foodbook.registration.RegistrationRequest;
import com.mmierzwa.foodbook.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @ApiOperation(value = "Method used to register a new user.")
    @PostMapping
    public String register(@Valid @RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @ApiIgnore
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
