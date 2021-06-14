package com.example.jpaexamples;

import com.example.jpaexamples.controllers.CourseController;
import com.example.jpaexamples.controllers.TeacherController;
import com.example.jpaexamples.entities.Course;
import com.example.jpaexamples.entities.Teacher;
import com.example.jpaexamples.repositories.CourseRepository;
import com.example.jpaexamples.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Engine implements CommandLineRunner {
    @Autowired
    TeacherController controller;

    @Autowired
    CourseController courseController;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        Teacher pesho = teacherRepository.getTeacherByFirstName("Pesho");
        courseController.setTeacherByName("Math", pesho);
        System.out.println(courseRepository.getCourseByTitle("Math"));
    }
}
