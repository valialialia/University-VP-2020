package com.botscrew.univ.services.impl;

import javax.persistence.EntityNotFoundException;

import com.botscrew.univ.exeption.DepartmentServiceException;
import com.botscrew.univ.models.impl.Department;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.repositories.DepartmentRepository;
import com.botscrew.univ.services.IDepartmentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService implements IDepartmentServise {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Transactional
    @Override
    public Lector getHeadOfDepartment(String departmentName) {
        final Department department;

        try {
           department = departmentRepository.findByName(departmentName);
        } catch (EntityNotFoundException ex) {
            throw new DepartmentServiceException("Department " + departmentName + " wasn't found");
        }
        final Lector lector = department.getHeadOfDepartment();

        return lector;
    }
}
