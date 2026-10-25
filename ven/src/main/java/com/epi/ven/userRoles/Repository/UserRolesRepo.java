package com.epi.ven.userRoles.Repository;

import com.epi.ven.userRoles.Model.UserRolesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolesRepo extends JpaRepository<UserRolesModel,Integer> {
    List<UserRolesModel> findByUsername(String userName);
}
