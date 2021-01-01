package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import com.botscrew.univ.models.ILectorDepartament;

@Entity
@Table(name = "obj_lector_departament")
public class LectorDepartament implements ILectorDepartament, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lector_departament")
    private Long idLectorDepartament;

    @ManyToOne
    @JoinColumn(name = "id_lector")
    private Lector lector;

    @ManyToOne
    @JoinColumn(name = "id_departament")
    private Departament departament;

    public LectorDepartament(Lector lector, Departament departament) {
        this.lector = lector;
        this.departament = departament;
    }

    public Long getIdLectorDepartament() {
        return idLectorDepartament;
    }

    public void setIdLectorDepartament(Long idLectorDepartament) {
        this.idLectorDepartament = idLectorDepartament;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LectorDepartament)) return false;
        LectorDepartament that = (LectorDepartament) o;
        return idLectorDepartament.equals(that.idLectorDepartament) &&
                lector.equals(that.lector) &&
                departament.equals(that.departament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLectorDepartament, lector, departament);
    }

    @Override
    public String toString() {
        return "LectorDepartament{" +
                "idLectorDepartament=" + idLectorDepartament +
                ", lector=" + lector +
                ", departament=" + departament +
                '}';
    }
}
