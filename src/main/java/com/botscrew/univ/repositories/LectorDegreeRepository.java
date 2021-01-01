package com.botscrew.univ.repositories;

import com.botscrew.univ.models.impl.LectorDegree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorDegreeRepository extends CrudRepository<LectorDegree, Long> {

    LectorDegree findByName(String name);
}
