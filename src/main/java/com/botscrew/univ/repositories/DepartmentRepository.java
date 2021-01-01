package com.botscrew.univ.repositories;

import com.botscrew.univ.models.impl.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department findByName(String name);

}
