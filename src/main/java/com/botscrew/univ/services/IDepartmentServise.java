package com.botscrew.univ.services;

import com.botscrew.univ.models.ILector;

public interface IDepartmentServise {

    ILector getHeadOfDepartment(String departmentName);
}
