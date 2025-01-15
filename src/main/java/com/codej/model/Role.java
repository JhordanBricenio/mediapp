package com.codej.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

        @Id
        @EqualsAndHashCode.Include
        private Integer idRole;

        @Column(name = "name", nullable = false, length = 50)
        private String name;

        @Column(name = "description",nullable = false, length = 150)
        private String description;
}
