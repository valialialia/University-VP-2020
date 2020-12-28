package com.botscrew.univ.repositories;

import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartament;
import org.springframework.data.repository.CrudRepository;

public interface LectorDepartamentRepository extends CrudRepository<LectorDepartament, Long> {

    LectorDepartament findByLector(Lector lector);

    LectorDepartament findByDepartament(Departament departament);
}
