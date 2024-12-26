package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String title, Pageable pageRequest);
}
