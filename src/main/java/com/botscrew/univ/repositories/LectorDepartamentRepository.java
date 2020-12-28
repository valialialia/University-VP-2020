package com.botscrew.univ.repositories;

import java.util.List;

import com.botscrew.univ.models.IDepartament;
import com.botscrew.univ.models.ILector;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LectorDepartamentRepository extends CrudRepository<LectorDepartament, Long> {

    LectorDepartament findByLector(ILector lector);

    LectorDepartament findByDepartament(IDepartament departament);


    @Query("SELECT COUNT(*) FROM obj_lector_departament ld " +
            "JOIN obj_departament d ON ld.id_departament = d.id_departament " +
            "WHERE d.name = :departamentName ")
    Integer getEmployeeCount(@Param("departamentName") String departamentName);



    @Query("SELECT AVG(salary) FROM obj_lector l " +
            "JOIN obj_lector_departament ld ON l.id_lector = ld.id_lector " +
            "JOIN obj_departamen d ON d.id_departament = ld.id_departament " +
            "WHERE d.name = :departamentName ")
    Integer getAverageSalary(@Param("String departamentName") String departamentName);


    @Query(value = "SELECT ldr.name, COUNT(*) FROM obj_lector_departament ld " +
            "JOIN obj_lector l ON l.id_lector = ld.id_lector" +
            "JOIN def_lector_degree ldr ON l.lector_degree = ldr.name " +
            "GROUP BY ldr.name")
    List<String> getStatistic();
}
