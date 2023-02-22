package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Faculty;
import com.hneu.qualification.repository.FacultyRepository;
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
public class FacultyController {

    private final FacultyRepository facultyRepository;

    @GetMapping("/faculties")
    public List<Faculty> getAll() {
        List<Faculty> faculties = new ArrayList<>();
        facultyRepository.findAll().forEach(faculties::add);
        return faculties;
    }

    @GetMapping("/faculty/{id}")
    public Faculty getFaculty(@PathVariable String id) {
        return facultyRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PostMapping("/faculty")
    public Faculty addNewGroup(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @GetMapping("/faculty")
    public Faculty getByName(@RequestParam String name) {
        return facultyRepository.findFacultyByName(name);
    }


}
