package com.example.jpaexamples.repositories;

import com.example.jpaexamples.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getTeacherByLastName(String lastName);
    Teacher getTeacherByFirstName(String firstName);
}
