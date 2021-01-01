package com.botscrew.univ.services;

import java.util.Map;

public interface ILectorDepartamentService {

    Integer getEmployeeCount(String departamentName);

    Double getAverageSalary(String departamentName);

    Map<String, Integer> getStatistic(String departamentName);
}
