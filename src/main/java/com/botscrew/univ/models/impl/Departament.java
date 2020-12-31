package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.botscrew.univ.models.IDepartament;
import com.sun.istack.NotNull;

@Entity
@Table(name = "obj_departament")
public class Departament implements IDepartament, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departament")
    private Long idDepartament;

    @NotNull
    @Column(name = "name", unique = true, nullable = false, length = 256)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_of_departament", referencedColumnName = "id_lector")
    private Lector headOfDepartament;

    @OneToMany(mappedBy= "departament")
    private Set<LectorDepartament> lectorDepartamentSet;

    public Departament(String name, Lector headOfDepartament) {
        this.name = name;
        this.headOfDepartament = headOfDepartament;
    }

    public Departament(String name, Lector headOfDepartament, Set<LectorDepartament> lectorDepartamentSet) {
        this.name = name;
        this.headOfDepartament = headOfDepartament;
        this.lectorDepartamentSet = lectorDepartamentSet;
    }

    public Long getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(Long idDepartament) {
        this.idDepartament = idDepartament;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Lector getHeadOfDepartament() {
        return headOfDepartament;
    }

    public void setHeadOfDepartament(Lector headOfDepartament) {
        this.headOfDepartament = headOfDepartament;
    }

    public Set<LectorDepartament> getLectorDepartamentSet() {
        return lectorDepartamentSet;
    }

    public void setLectorDepartamentSet(Set<LectorDepartament> lectorDepartamentSet) {
        this.lectorDepartamentSet = lectorDepartamentSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departament)) return false;
        Departament that = (Departament) o;
        return idDepartament.equals(that.idDepartament) &&
                name.equals(that.name) &&
                headOfDepartament.equals(that.headOfDepartament) &&
                lectorDepartamentSet.equals(that.lectorDepartamentSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartament, name, headOfDepartament, lectorDepartamentSet);
    }

    @Override
    public String toString() {
        return "Departament{" +
                "idDepartament=" + idDepartament +
                ", name='" + name + '\'' +
                ", headOfDepartament=" + headOfDepartament +
                ", lectorDepartamentSet=" + lectorDepartamentSet +
                '}';
    }
}
