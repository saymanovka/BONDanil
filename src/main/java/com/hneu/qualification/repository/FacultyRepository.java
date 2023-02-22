package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

    Faculty findFacultyByName(String name);

}
