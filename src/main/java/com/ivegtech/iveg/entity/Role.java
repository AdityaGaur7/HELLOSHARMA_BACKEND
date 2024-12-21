package com.ivegtech.iveg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles", schema = "public")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "role_name", length = 50, nullable = false, unique = true)
    private String roleName;

    // Constructors, Getters, and Setters

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
