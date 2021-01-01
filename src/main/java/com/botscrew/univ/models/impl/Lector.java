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

    @OneToOne
    @JoinColumn(name = "lector_degree", referencedColumnName = "id_lector_degree")
    private LectorDegree lectorDegree;

    @NotNull
    private Integer salary;

    @OneToMany(mappedBy = "lector")
    private Set<LectorDepartment> lectorDepartmentSet;

    public Lector(String firstName, String lastName, LectorDegree lectorDegree, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectorDegree = lectorDegree;
        this.salary = salary;
    }

    public Lector(String firstName, String lastName, LectorDegree lectorDegree, Integer salary, Set<LectorDepartment> lectorDepartmentSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectorDegree = lectorDegree;
        this.salary = salary;
        this.lectorDepartmentSet = lectorDepartmentSet;
    }

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

    @Override
    public LectorDegree getLectorDegree() {
        return lectorDegree;
    }

    public void setLectorDegree(LectorDegree lectorDegree) {
        this.lectorDegree = lectorDegree;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
        if (!(o instanceof Lector)) return false;
        Lector lector = (Lector) o;
        return Objects.equals(idLector, lector.idLector) &&
                firstName.equals(lector.firstName) &&
                lastName.equals(lector.lastName) &&
                lectorDegree.equals(lector.lectorDegree) &&
                salary.equals(lector.salary) &&
                lectorDepartmentSet.equals(lector.lectorDepartmentSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLector, firstName, lastName, lectorDegree, salary, lectorDepartmentSet);
    }

    @Override
    public String toString() {
        return "Lector{" +
                "idLector=" + idLector +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lectorDegree=" + lectorDegree +
                ", salary=" + salary +
                ", lectorDepartmentSet=" + lectorDepartmentSet +
                '}';
    }
}
