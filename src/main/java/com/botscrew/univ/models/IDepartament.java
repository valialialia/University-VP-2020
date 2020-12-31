package com.botscrew.univ.models;


import java.util.Set;

import com.botscrew.univ.models.impl.LectorDepartament;

/**
 * Interface for Departament data exchange with Service Layer
 */
public interface IDepartament {
    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @return
     */
    ILector getHeadOfDepartament();

    Set<LectorDepartament> getLectorDepartamentSet();
}
