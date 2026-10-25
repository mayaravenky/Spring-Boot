package com.epi.ven.userRoles.Service;

import com.epi.ven.userRoles.Model.UserRolesModel;
import com.epi.ven.userRoles.Repository.UserRolesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesService {
    private final UserRolesRepo userRolesRepo;
    public UserRolesService(UserRolesRepo userRolesRepo) {
        this.userRolesRepo = userRolesRepo;
    }
    public List<UserRolesModel> getAllUserRoles(){
        return userRolesRepo.findAll();
    }
    public List<UserRolesModel> findByUsername(String userName){
        return userRolesRepo.findByUsername(userName);
    }
    public List<UserRolesModel> getRolesByUsername(String userName){
        return userRolesRepo.findByUsername(userName);
    }

}
