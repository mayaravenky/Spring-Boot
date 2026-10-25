package com.epi.ven.userRoles.Controller;

import com.epi.ven.userRoles.Model.UserRolesModel;
import com.epi.ven.userRoles.Service.UserRolesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userRoles")
public class UserRolesController {
    private final UserRolesService userRolesService;

    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }
    @GetMapping("/users")
    public List<UserRolesModel> getAllUserRoles(){
        return userRolesService.getAllUserRoles();
    }
}
