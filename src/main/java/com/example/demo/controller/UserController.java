package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Endpoints for managing users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hi";
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find the User by CPF", description = "Find the user has able to vote.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    public String cpf(@PathVariable String cpf) {
        return userService.getAbleToVote(cpf);
    }

    @GetMapping(value = "{cpf}/all", produces = "application/json")
    public User all(@PathVariable String cpf) {
        return userService.getAll(cpf);
    }

    @GetMapping(value = "/save")
    public User save(@RequestParam String cpf, @RequestParam String name, @RequestParam Boolean able) {
        return userService.save(cpf, name, able);
    }

}
