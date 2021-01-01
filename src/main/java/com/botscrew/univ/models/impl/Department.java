package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.botscrew.univ.models.IDepartment;
import com.sun.istack.NotNull;

@Entity
@Table(name = "obj_department")
public class Department implements IDepartment, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    private Long idDepartment;

    @NotNull
    @Column(name = "name", unique = true, nullable = false, length = 256)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_of_department", referencedColumnName = "id_lector")
    private Lector headOfDepartment;

    @OneToMany(mappedBy= "department")
    private Set<LectorDepartment> lectorDepartmentSet;

    public Department(String name, Lector headOfDepartment) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
    }

    public Department(String name, Lector headOfDepartment, Set<LectorDepartment> lectorDepartmentSet) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
        this.lectorDepartmentSet = lectorDepartmentSet;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Lector getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Lector headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Set<LectorDepartment> getLectorDepartmentSet() {
        return lectorDepartmentSet;
    }

    public void setLectorDepartmentSet(Set<LectorDepartment> lectorDepartmentSet) {
        this.lectorDepartmentSet = lectorDepartmentSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return idDepartment.equals(that.idDepartment) &&
                name.equals(that.name) &&
                headOfDepartment.equals(that.headOfDepartment) &&
                lectorDepartmentSet.equals(that.lectorDepartmentSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, name, headOfDepartment, lectorDepartmentSet);
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", name='" + name + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                ", lectorDepartmentSet=" + lectorDepartmentSet +
                '}';
    }
}
