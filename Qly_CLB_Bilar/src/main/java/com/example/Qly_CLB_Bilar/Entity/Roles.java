package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Roles {
    @Id
    private String name;
    private String discription;
    @ManyToMany
    private Set<Permisstion> permisstion;

}
