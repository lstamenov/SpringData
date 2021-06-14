package com.example.jpaexamples.controllers;

import com.example.jpaexamples.entities.Teacher;
import com.example.jpaexamples.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourseController {
    @Autowired
    CourseRepository repository;

    public void setTeacherByName(String title, Teacher teacher){
        repository.getCourseByTitle(title).setTeacher(teacher);
    }
}
