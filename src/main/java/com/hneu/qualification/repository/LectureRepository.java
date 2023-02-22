package com.hneu.qualification.repository;

import com.hneu.qualification.entity.Lecture;
import com.hneu.qualification.entity.LectureType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Integer> {

    List<Lecture> findLecturesByLector_LectorId(Integer lectorId);
    List<Lecture> findLecturesByGroup_GroupId(Integer groupId);
    List<Lecture> findLecturesByLectureType(LectureType lectureType);
    List<Lecture> findLecturesBySubject_SubjectId(Integer subjectId);

}
