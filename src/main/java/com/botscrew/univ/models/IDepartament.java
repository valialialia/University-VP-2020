package com.botscrew.univ.models;


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
}
