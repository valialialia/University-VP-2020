package com.botscrew.univ.repositories;


import com.botscrew.univ.models.impl.Lector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<Lector, Long> {

    Lector findByLastName(String lastName);


}
