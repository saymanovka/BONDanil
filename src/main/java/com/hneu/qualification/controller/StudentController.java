package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Student;
import com.hneu.qualification.repository.GroupRepository;
import com.hneu.qualification.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping("/students")
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getById(@PathVariable String id) {
        return studentRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @GetMapping("/student")
    public Student getByName(@RequestParam String name) {
        return studentRepository.findStudentByName(name);
    }

    @PostMapping("/student")
    public Student addNew(@RequestBody Student student, @RequestParam Integer groupId) {
        student.setGroup(groupRepository.findById(groupId).orElseThrow());
        return studentRepository.save(student);
    }

}
