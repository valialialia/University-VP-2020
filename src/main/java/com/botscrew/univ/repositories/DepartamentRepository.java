package com.botscrew.univ.repositories;

import java.util.Optional;
import java.util.UUID;

import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentRepository extends CrudRepository<Departament, Long> {

    Departament findByName(String name);
}
