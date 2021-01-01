package com.botscrew.univ.repositories;

import java.util.Set;

import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorDepartamentRepository extends CrudRepository<LectorDepartament, Long> {

    Set<LectorDepartament> findAllByDepartament(Departament departament);

    Set<LectorDepartament> findAllByLector(Lector lector);

}
