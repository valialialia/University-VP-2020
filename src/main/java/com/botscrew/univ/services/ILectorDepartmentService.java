package com.botscrew.univ.services;

import java.util.Map;

public interface ILectorDepartmentService {

    Integer getEmployeeCount(String departamentName);

    Double getAverageSalary(String departamentName);

    Map<String, Integer> getStatistic(String departamentName);
}
