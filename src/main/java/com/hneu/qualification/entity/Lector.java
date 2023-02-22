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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lectorId;

    @Column(length = 30)
    private String name;

    @Column(length = 16)
    private String phone;

    @Column
    private String address;

    @Column(nullable = false)
    private double salary;

}
