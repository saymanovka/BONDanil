package com.hneu.qualification.controller;

import com.hneu.qualification.entity.Group;
import com.hneu.qualification.repository.GroupRepository;
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
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping("/groups")
    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();
        groupRepository.findAll().forEach(groups::add);
        return groups;
    }

    @GetMapping("/group/{id}")
    public Group getGroup(@PathVariable String id) {
        return groupRepository.findById(Integer.valueOf(id)).orElse(null);
    }

    @PostMapping("/group")
    public Group addNewGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    @GetMapping("/group")
    public Group getGroupByName(@RequestParam String name) {
        return groupRepository.findGroupByName(name);
    }
}
