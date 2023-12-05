package com.vac_mis.model;

import com.vac_mis.model.enums.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Information {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String IdNumber;
    private String patientName;
    @Enumerated(EnumType.STRING)
    private EGender eGender;
    private LocalDate dob;
    @ManyToOne
    @JoinColumn(name = "vac_Id")
    private Vaccine vaccine;
    @ManyToOne
    @JoinColumn(name = "nurse_Id")
    private Users nurse;
}
