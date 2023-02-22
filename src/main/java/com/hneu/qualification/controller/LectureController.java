package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Group;
import com.hneu.qualification.entity.Lector;
import com.hneu.qualification.entity.Lecture;
import com.hneu.qualification.entity.LectureType;
import com.hneu.qualification.repository.GroupRepository;
import com.hneu.qualification.repository.LectorRepository;
import com.hneu.qualification.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {

    private final LectureRepository lectureRepository;
    private final GroupRepository groupRepository;
    private final LectorRepository lectorRepository;

    @GetMapping("/lectures")
    public List<Lecture> getAll() {
        List<Lecture> lectures = new ArrayList<>();
        lectureRepository.findAll().forEach(lectures::add);
        return lectures;
    }

    @PostMapping("/lecture")
    public Lecture addNew(@RequestBody Lecture lecture, @RequestParam Integer groupId, @RequestParam Integer lectorId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        Lector lector = lectorRepository.findById(lectorId).orElse(null);
        lecture.setLector(lector);
        lecture.setGroup(group);
        return lectureRepository.save(lecture);
    }

    @GetMapping("/lectures/group/{groupId}")
    public List<Lecture> findLecturesByGroupId(@PathVariable Integer groupId) {
        return lectureRepository.findLecturesByGroup_GroupId(groupId);
    }

    @GetMapping("/lectures/lector/{lectorId}")
    public List<Lecture> findLecturesByLectorId(@PathVariable Integer lectorId) {
        return lectureRepository.findLecturesByLector_LectorId(lectorId);
    }

    @GetMapping("/lectures/{lectureType}")
    public List<Lecture> findLecturesByLectorId(@PathVariable LectureType lectureType) {
        return lectureRepository.findLecturesByLectureType(lectureType);
    }

    @GetMapping("/lectures/subject/{subjectId}")
    public List<Lecture> findLecturesBySubjectId(@PathVariable Integer subjectId) {
        return lectureRepository.findLecturesBySubject_SubjectId(subjectId);
    }

}
