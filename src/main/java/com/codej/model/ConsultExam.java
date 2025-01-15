package com.codej.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consult_exam")
@IdClass(ConsultExamPK.class)
public class ConsultExam {

    @Id
    private Consult consult;

    @Id
    private Exam exam;
}
