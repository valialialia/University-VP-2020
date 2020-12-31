package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

import com.botscrew.univ.models.ILectorDegree;
import com.sun.istack.NotNull;

@Entity
@Table(name = "def_lector_degree")
public class LectorDegree implements ILectorDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lector_degree")
    private Long idLectorDegree;

    @NotNull
    @Column(name = "name", unique = true, nullable = false, length = 256)
    private String name;

    public LectorDegree(String name) {
        this.name = name;
    }

    public Long getIdLectorDegree() {
        return idLectorDegree;
    }

    public void setIdLectorDegree(Long idLectorDegree) {
        this.idLectorDegree = idLectorDegree;
    }

    @Override
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
        return idLectorDegree.equals(that.idLectorDegree) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLectorDegree, name);
    }

    @Override
    public String toString() {
        return "LectorDegree{" +
                "idLectorDegree=" + idLectorDegree +
                ", name='" + name + '\'' +
                '}';
    }
}
