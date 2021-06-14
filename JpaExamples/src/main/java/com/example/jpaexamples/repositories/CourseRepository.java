package com.example.jpaexamples.repositories;

import com.example.jpaexamples.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getCourseByTitle(String title);
}
