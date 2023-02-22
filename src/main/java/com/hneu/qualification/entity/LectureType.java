package com.hneu.qualification.entity;

import lombok.Getter;

public enum LectureType {

    PRACTICE(100),
    LECTURE(150);

    @Getter
    private final int price;

    LectureType(int price) {
        this.price = price;
    }
}
