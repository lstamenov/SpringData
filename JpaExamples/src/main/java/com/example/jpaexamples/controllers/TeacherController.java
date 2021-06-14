package com.example.jpaexamples.controllers;

import com.example.jpaexamples.entities.Course;
import com.example.jpaexamples.entities.Teacher;
import com.example.jpaexamples.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    public void addCourse(Teacher teacher, Course course){
        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        teacherRepository.saveAndFlush(teacher);
    }

    public void createTeacher(Teacher teacher){
        teacherRepository.saveAndFlush(teacher);
    }
}
