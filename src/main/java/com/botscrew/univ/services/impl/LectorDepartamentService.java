package com.botscrew.univ.services.impl;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.botscrew.univ.exeption.LectorDepartamentServiceException;
import com.botscrew.univ.models.enums.LectorDegreeEnum;
import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartament;
import com.botscrew.univ.repositories.DepartamentRepository;
import com.botscrew.univ.repositories.LectorDepartamentRepository;
import com.botscrew.univ.repositories.LectorRepository;
import com.botscrew.univ.services.ILectorDepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LectorDepartamentService implements ILectorDepartamentService {

    private final LectorDepartamentRepository lectorDepartamentRepository;
    private final DepartamentRepository departamentRepository;
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorDepartamentService(LectorDepartamentRepository lectorDepartamentRepository,
                                    DepartamentRepository departamentRepository,
                                    LectorRepository lectorRepository) {
        this.lectorDepartamentRepository = lectorDepartamentRepository;
        this.departamentRepository = departamentRepository;
        this.lectorRepository = lectorRepository;
    }

    @Transactional
    @Override
    public Integer getEmployeeCount(String departamentName){
        final Departament departament = departamentRepository.findByName(departamentName);
        final Set<LectorDepartament> lectorDepartamentSet;

        try {
            lectorDepartamentSet = lectorDepartamentRepository.findAllByDepartament(departament);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartamentServiceException("LectorDepartment with Departament name: " + departamentName + " wasn't found");
        }

        return lectorDepartamentSet.size();
    }

    @Transactional
    @Override
    public Double getAverageSalary(String departamentName) {
        final Departament departament = departamentRepository.findByName(departamentName);
        final Set<LectorDepartament> lectorDepartamentSet;

        try {
            lectorDepartamentSet = lectorDepartamentRepository.findAllByDepartament(departament);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartamentServiceException("LectorDepartment with Departament name: " + departamentName + " wasn't found");
        }

       final List<Lector> lectors = lectorDepartamentSet
               .stream()
               .map(LectorDepartament::getLector)
               .collect(Collectors.toList());

        return lectors
                .stream()
                .mapToInt(Lector::getSalary)
                .average()
                .getAsDouble();
    }

    @Transactional
    @Override
    public Map<String, Integer> getStatistic(String departamentName) {

        final Departament departament = departamentRepository.findByName(departamentName);
        final Set<LectorDepartament> lectorDepartamentSet;

        try {
            lectorDepartamentSet = lectorDepartamentRepository.findAllByDepartament(departament);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartamentServiceException("LectorDepartment with Departament name: " + departamentName + " wasn't found");
        }

        final List<Lector> lectors = lectorDepartamentSet
                .stream()
                .map(LectorDepartament::getLector)
                .collect(Collectors.toList());


        Map<String, Integer> statistic = new HashMap<>();

        // TODO: 01.01.2021 Remove hardcode

        statistic.put(LectorDegreeEnum.ASSISTANT.toString(), (int) lectors
                .stream()
                .filter(lector -> lector.getLectorDegree().equals(LectorDegreeEnum.ASSISTANT))
                .count());

        statistic.put(LectorDegreeEnum.ASSOCIATE_PROFESSOR.toString(), (int) lectors
                .stream()
                .filter(lector -> lector.getLectorDegree().equals(LectorDegreeEnum.ASSOCIATE_PROFESSOR))
                .count());

        statistic.put(LectorDegreeEnum.PROFESSOR.toString(), (int) lectors
                .stream()
                .filter(lector -> lector.getLectorDegree().equals(LectorDegreeEnum.PROFESSOR))
                .count());

        return statistic;
    }
}
