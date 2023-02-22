package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Lector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<Lector, Integer> {

    Lector findLectorByName(String name);

}
