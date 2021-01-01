package com.botscrew.univ.services.impl;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.botscrew.univ.exeption.LectorDepartmentServiceException;
import com.botscrew.univ.models.enums.LectorDegreeEnum;
import com.botscrew.univ.models.impl.Department;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartment;
import com.botscrew.univ.repositories.DepartmentRepository;
import com.botscrew.univ.repositories.LectorDepartmentRepository;
import com.botscrew.univ.repositories.LectorRepository;
import com.botscrew.univ.services.ILectorDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LectorDepartmentService implements ILectorDepartmentService {

    private final LectorDepartmentRepository lectorDepartmentRepository;
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Autowired
    public LectorDepartmentService(LectorDepartmentRepository lectorDepartmentRepository,
                                   DepartmentRepository departmentRepository,
                                   LectorRepository lectorRepository) {
        this.lectorDepartmentRepository = lectorDepartmentRepository;
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    @Transactional
    @Override
    public Integer getEmployeeCount(String departmentName){
        final Department department = departmentRepository.findByName(departmentName);
        final Set<LectorDepartment> lectorDepartmentSet;

        try {
            lectorDepartmentSet = lectorDepartmentRepository.findAllByDepartment(department);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartmentServiceException("LectorDepartment with Department name: " + departmentName + " wasn't found");
        }

        return lectorDepartmentSet.size();
    }

    @Transactional
    @Override
    public Double getAverageSalary(String departmentName) {
        final Department department = departmentRepository.findByName(departmentName);
        final Set<LectorDepartment> lectorDepartmentSet;

        try {
            lectorDepartmentSet = lectorDepartmentRepository.findAllByDepartment(department);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartmentServiceException("LectorDepartment with Department name: " + departmentName + " wasn't found");
        }

       final List<Lector> lectors = lectorDepartmentSet
               .stream()
               .map(LectorDepartment::getLector)
               .collect(Collectors.toList());

        return lectors
                .stream()
                .mapToInt(Lector::getSalary)
                .average()
                .getAsDouble();
    }

    @Transactional
    @Override
    public Map<String, Integer> getStatistic(String departmentName) {

        final Department department = departmentRepository.findByName(departmentName);
        final Set<LectorDepartment> lectorDepartmentSet;

        try {
            lectorDepartmentSet = lectorDepartmentRepository.findAllByDepartment(department);
        } catch (EntityNotFoundException ex) {
            throw new LectorDepartmentServiceException("LectorDepartment with Department name: " + departmentName + " wasn't found");
        }

        final List<Lector> lectors = lectorDepartmentSet
                .stream()
                .map(LectorDepartment::getLector)
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
