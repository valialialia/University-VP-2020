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

import com.botscrew.univ.models.ILectorDepartment;

@Entity
@Table(name = "obj_lector_department")
public class LectorDepartment implements ILectorDepartment, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lector_department")
    private Long idLectorDepartment;

    @ManyToOne
    @JoinColumn(name = "id_lector")
    private Lector lector;

    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;

    public LectorDepartment(Lector lector, Department department) {
        this.lector = lector;
        this.department = department;
    }

    public Long getIdLectorDepartment() {
        return idLectorDepartment;
    }

    public void setIdLectorDepartment(Long idLectorDepartment) {
        this.idLectorDepartment = idLectorDepartment;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LectorDepartment)) return false;
        LectorDepartment that = (LectorDepartment) o;
        return idLectorDepartment.equals(that.idLectorDepartment) &&
                lector.equals(that.lector) &&
                department.equals(that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLectorDepartment, lector, department);
    }

    @Override
    public String toString() {
        return "LectorDepartment{" +
                "idLectorDepartment=" + idLectorDepartment +
                ", lector=" + lector +
                ", departament=" + department +
                '}';
    }
}
