package com.example.dao;

import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.service.SchoolService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SchoolServiceTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        SchoolService schoolService = context.getBean("schoolServiceImpl", SchoolService.class);

        Teacher teacher = new Teacher("Bill");
//        Student stu = new Student("Luna", 22, new Date());
        Student stu = new Student("Luna", 22, null);
        schoolService.insertTeacherAndStudent(teacher, stu);
    }
}
