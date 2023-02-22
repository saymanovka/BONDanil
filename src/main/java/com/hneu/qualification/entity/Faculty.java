package com.hneu.qualification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facultyId;

    @Column(length = 30)
    private String name;

}
