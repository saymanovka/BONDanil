package com.hneu.qualification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lectureId;

    @Column
    private LocalDateTime time;

    @Column
    private LectureType lectureType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="lector_id", nullable=false)
    private Lector lector;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id", nullable=false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="group_id", nullable=false)
    private Group group;

}
