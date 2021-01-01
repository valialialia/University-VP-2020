package com.botscrew.univ.models;


import java.util.Set;

import com.botscrew.univ.models.impl.LectorDepartment;

/**
 * Interface for Departament data exchange with Service Layer
 */
public interface IDepartment {
    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @return
     */
    ILector getHeadOfDepartment();

    Set<LectorDepartment> getLectorDepartmentSet();
}
