package com.epi.ven.auth;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;
    public AuthService(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void registerUser(String username, String rawPassword) {
        String passwordHash = passwordEncoder.encode(rawPassword);

        jdbcTemplate.update(
                "INSERT INTO dbo.users (username,password) VALUES (?,?)",
                username, passwordHash
        );
        jdbcTemplate.update(
                "INSERT INTO dbo.user_roles (username,role) VALUES (?,?)",
                username, "ROLE_USER"
        );

    }
}
