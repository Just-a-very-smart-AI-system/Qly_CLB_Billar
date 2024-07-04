package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @Column(name = "user_name", nullable = false, length = 50)
    private String user_name;
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @JoinColumn(name = "Staff_ID", nullable = false)
    @ManyToOne
    private Staff staff;

    @ManyToMany
    private Set<Roles> roles;

}
