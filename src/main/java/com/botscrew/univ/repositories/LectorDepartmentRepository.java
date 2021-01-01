package com.botscrew.univ.repositories;

import java.util.Set;

import com.botscrew.univ.models.impl.Department;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorDepartmentRepository extends CrudRepository<LectorDepartment, Long> {

    Set<LectorDepartment> findAllByDepartment(Department department);

    Set<LectorDepartment> findAllByLector(Lector lector);

}
