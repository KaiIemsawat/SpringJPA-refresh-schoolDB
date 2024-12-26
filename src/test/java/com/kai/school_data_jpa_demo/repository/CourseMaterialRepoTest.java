package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import com.kai.school_data_jpa_demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("JPA")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.doggos.com")
                .course(course)
                .build();

        courseMaterialRepo.save(courseMaterial);
    }
}