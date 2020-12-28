package com.botscrew.univ.repositories;

import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepartamentRepository extends CrudRepository<Departament, Long> {

    Departament findByName(String name);

    @Query("SElECT head_of_departamen FROM obj_departament d WHERE d.name = :name")
    Lector getHeadOfDepartament(@Param("name") String name);
}
