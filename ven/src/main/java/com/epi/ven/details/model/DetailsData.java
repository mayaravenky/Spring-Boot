package com.epi.ven.details.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "details")
public class DetailsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String city;

    @Column()
    private Integer age;

}
