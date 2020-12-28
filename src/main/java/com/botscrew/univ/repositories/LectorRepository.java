package com.botscrew.univ.repositories;


import com.botscrew.univ.models.impl.Lector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<Lector, Long> {

    Lector findByLastName(String lastName);

    @Query("SELECT first_name, last_name FROM obj_lector l " +
            "WHERE l.first_name LIKE %:nameLike% " +
            "OR l.last_name LIKE %:nameLike%")
    Lector getLectorLike(@Param("nameLike") String nameLike);

}
