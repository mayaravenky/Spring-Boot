package com.epi.ven.security;

import com.epi.ven.userRoles.Model.UserRolesModel;
import com.epi.ven.userRoles.Service.UserRolesService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRolesService userRolesService;
    private final JdbcTemplate jdbcTemplate;

    public CustomUserDetailsService(UserRolesService userRolesService,
                                    JdbcTemplate jdbcTemplate) {
        this.userRolesService = userRolesService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        String passwordHash;
        try{
            passwordHash = jdbcTemplate.queryForObject(
                    "SELECT password FROM dbo.users WHERE username = ?",
                    String.class, username
            );
        }catch(EmptyResultDataAccessException e){
            throw new UsernameNotFoundException("Username not found");
        }
        List<UserRolesModel> roles = userRolesService.getRolesByUsername(username);
        var authorities = roles.stream()
                .map(role->
                        new SimpleGrantedAuthority(role.getRole()))
                .toList();
        return User.withUsername(username)
                .password(passwordHash)
                .authorities(authorities)
                .build();
    }
}
