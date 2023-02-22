package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    Group findGroupByName(String name);

}
