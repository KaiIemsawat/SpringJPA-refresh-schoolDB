package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import com.kai.school_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepo.findAll();
        System.out.println("Course : " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Vernon")
                .lastName("Va")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepo.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepo.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepo.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Courses : " + courses);
        System.out.println("Total Elements : " + totalElements);
        System.out.println("Total Pages : " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(0, 3, Sort.by("credit").descending());
        Pageable sortByTitleAndCredit = PageRequest.of(
                0,
                3,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepo.findAll(sortByTitle).getContent();
        System.out.println("Courses : " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepo.findByTitleContaining("n", firstPageTenRecords).getContent();

        System.out.println("Course : " + courses);
    }
}