package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findStudentByName(String name);

}
