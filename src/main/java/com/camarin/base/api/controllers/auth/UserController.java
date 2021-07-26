package com.camarin.base.api.controllers.auth;

import com.camarin.base.domain.dto.UserDto;
import com.camarin.base.domain.services.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserDto user) {
        return this.userService.create(user);
    }


}
