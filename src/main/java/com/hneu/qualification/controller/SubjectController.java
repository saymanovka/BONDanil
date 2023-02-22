package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Subject;
import com.hneu.qualification.repository.SubjectRepository;
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
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);
        return subjects;
    }

    @GetMapping("/subject/{id}")
    public Subject getSubject(@PathVariable String id) {
        return subjectRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PostMapping("/subject")
    public Subject addNewGroup(@RequestBody Subject group) {
        return subjectRepository.save(group);
    }

    @GetMapping("/subject")
    public Subject getSubjectByName(@RequestParam String name) {
        return subjectRepository.findSubjectByName(name);
    }


}
