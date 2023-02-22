package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

    Subject findSubjectByName(String name);

}
