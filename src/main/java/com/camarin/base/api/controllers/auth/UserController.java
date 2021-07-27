package com.camarin.base.api.controllers.auth;

import com.camarin.base.api.controllers.BaseController;
import com.camarin.base.domain.dto.UserDto;
import com.camarin.base.domain.services.auth.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping(path = "/users")
public class UserController extends BaseController<UserDto, Long> {

    @Autowired
    public UserController(IUserService userService) {
        super(userService);
    }
}
