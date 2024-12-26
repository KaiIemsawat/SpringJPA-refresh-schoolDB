package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
