package com.botscrew.univ.models;


/**
 * Interface for Lector data exchange with Service Layer
 */
public interface ILector {

    /**
     * Returns Lector's first name
     *
     * @return Lector's first name
     */
    String getFirstName();

    /**
     * Returns Lector's last name
     *
     * @return Lector's last name
     */
    String getLastName();

    /**
     * Returns Lector's degree
     *
     * @return Lector's degree
     */
    ILectorDegree getLectorDegree();



    /**
     * Returns Lector's salary
     *
     * @return Lector's salary
     */
    int getSalary();

}
