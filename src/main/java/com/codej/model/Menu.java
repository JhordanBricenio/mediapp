package com.codej.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Menu {

    @Id
    @EqualsAndHashCode.Include
    private String idMenu;

    @Column(name = "icon", nullable = false, length = 20)
    private String icon;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "url", nullable = false, length = 50)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_role",
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "idMenu"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "idRole")
    )
    private List<Role> roles;
}
