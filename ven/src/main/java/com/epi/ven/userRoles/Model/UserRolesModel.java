package com.epi.ven.userRoles.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_roles")
public class UserRolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String username;

    @Column()
    private String role;
}
