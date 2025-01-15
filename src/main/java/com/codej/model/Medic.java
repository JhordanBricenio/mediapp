package com.codej.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medic")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID idMedic;

    @ManyToOne
    @JoinColumn(name = "id_specialty", nullable = false, foreignKey = @ForeignKey(name = "fk_medic_specialty"))
    private Specialty specialty;

    @Column(name = "first_name", nullable = false, length = 70)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 70)
    private String lastName;

    @Column(name = "cmp", nullable = false, length = 12)
    private String cmp;

    @Column(name = "photo", length = 250)
    private String photoUrl;

}
