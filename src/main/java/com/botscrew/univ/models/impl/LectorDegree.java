package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

import com.sun.istack.NotNull;

@Entity
@Table(name = "def_lector_degree")
public class LectorDegree {

    @Id
    @Column(name = "id_lector_degree")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActorRole;

    @NotNull
    @Column(name = "name", unique = true, nullable = false, length = 256)
    private String name;

    public Long getIdActorRole() {
        return idActorRole;
    }

    public void setIdActorRole(Long idActorRole) {
        this.idActorRole = idActorRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LectorDegree)) return false;
        LectorDegree that = (LectorDegree) o;
        return idActorRole.equals(that.idActorRole) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActorRole, name);
    }

    @Override
    public String toString() {
        return "LectorDegree{" +
                "idActorRole=" + idActorRole +
                ", name='" + name + '\'' +
                '}';
    }
}
