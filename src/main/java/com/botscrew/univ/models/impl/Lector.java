package com.botscrew.univ.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.botscrew.univ.models.ILector;
import com.sun.istack.NotNull;

@Entity
@Table(name = "obj_lector")
public class Lector implements ILector, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lector")
    private Long idLector;

    @NotNull
    @Column(name = "first_name", nullable = false, length = 256)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false, length = 256)
    private String lastName;

    @ManyToMany
    private List<LectorDegree> lectorDegrees = new ArrayList<>();

    @NotNull
    private Integer salary;

    public Long getIdLector() {
        return idLector;
    }

    public void setIdLector(Long idLector) {
        this.idLector = idLector;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<LectorDegree> getLectorDegrees() {
        return lectorDegrees;
    }

    public void setLectorDegrees(List<LectorDegree> lectorDegrees) {
        this.lectorDegrees = lectorDegrees;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lector)) return false;
        Lector lector = (Lector) o;
        return idLector.equals(lector.idLector) &&
                firstName.equals(lector.firstName) &&
                lastName.equals(lector.lastName) &&
                lectorDegrees.equals(lector.lectorDegrees) &&
                salary.equals(lector.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLector, firstName, lastName, lectorDegrees, salary);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "idLector=" + idLector +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lectorDegrees=" + lectorDegrees +
                ", salary=" + salary +
                '}';
    }
}
