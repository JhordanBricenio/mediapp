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
@Table(name = "consult_detail")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID idConsultDetail;


    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_consult"))
    private Consult consult;

    @Column(name = "diagnosis", nullable = false, length = 70)
    private String diagnosis;

    @Column(name = "treatment", nullable = false, length = 70)
    private String treatment;
}
