package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Lector;
import com.hneu.qualification.repository.LectorRepository;
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
public class LectorController {

    private final LectorRepository lectorRepository;

    @GetMapping("/lectors")
    public List<Lector> getAll() {
        List<Lector> lectors = new ArrayList<>();
        lectorRepository.findAll().forEach(lectors::add);
        return lectors;
    }

    @GetMapping("/lector/{id}")
    public Lector getLectorById(@PathVariable String id) {
        return lectorRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PostMapping("/lector")
    public Lector addNew(@RequestBody Lector lector) {
        return lectorRepository.save(lector);
    }

    @GetMapping("/lector")
    public Lector getLectorByName(@RequestParam String name) {
        return lectorRepository.findLectorByName(name);
    }
}
