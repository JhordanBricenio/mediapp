package com.codej.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consult")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID idConsult;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "fk_consult_patient"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_consult_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_medic", nullable = false, foreignKey = @ForeignKey(name = "fk_consult_medic"))
    private Medic medic;

    @Column(name = "num_consult", nullable = false, length = 3)
    private String numConsult;

    @Column(name = "consult_date", nullable = false)
    private LocalDateTime consultDate;

    @OneToMany(mappedBy = "consult", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultDetail> details;


}
