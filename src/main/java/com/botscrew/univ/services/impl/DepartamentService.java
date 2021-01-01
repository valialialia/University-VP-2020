package com.botscrew.univ.services.impl;

import javax.persistence.EntityNotFoundException;

import com.botscrew.univ.exeption.DepartamentServiceException;
import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.repositories.DepartamentRepository;
import com.botscrew.univ.services.IDepartamentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartamentService implements IDepartamentServise {

    private final DepartamentRepository departamentRepository;

    @Autowired
    public DepartamentService(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }


    @Transactional
    @Override
    public Lector getHeadOfDepartament(String departamentName) {
        final Departament departament;

        try {
           departament = departamentRepository.findByName(departamentName);
        } catch (EntityNotFoundException ex) {
            throw new DepartamentServiceException("Department " + departamentName + " wasn't found");
        }
        final Lector lector = departament.getHeadOfDepartament();

        return lector;
    }
}
