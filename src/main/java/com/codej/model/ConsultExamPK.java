package com.codej.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ConsultExamPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "fk_consult_exam"))
    private Consult consult;

    @ManyToOne
    @JoinColumn(name = "id_exam", nullable = false, foreignKey = @ForeignKey(name = "fk_exam_consult"))
    private  Exam exam;
}
