package com.vac_mis.model;

import com.vac_mis.model.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String name;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private ERole role;
}
