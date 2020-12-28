package com.botscrew.univ.models;

import com.botscrew.univ.models.impl.Lector;

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
    Lector getHeadOfDepartament();
}
