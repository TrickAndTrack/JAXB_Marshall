package com.jaxb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @NotNull
    private String email;
    @Size(max = 256, message = "address should have maximum 256 characters")
    private String address;
    private String userUniqueNumber;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}