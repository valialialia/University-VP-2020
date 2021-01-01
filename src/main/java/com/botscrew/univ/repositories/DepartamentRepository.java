package com.botscrew.univ.repositories;

import com.botscrew.univ.models.impl.Departament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends CrudRepository<Departament, Long> {

    Departament findByName(String name);

}
