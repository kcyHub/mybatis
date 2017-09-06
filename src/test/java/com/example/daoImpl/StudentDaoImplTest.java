package com.example.daoImpl;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {

    private StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void insertStudent() {
        Student stu = new Student("Bob", 25, new Date());
        assertEquals(1, studentDao.insertStudent(stu));
    }

    @Test
    public void selectById() {
        Student stu = studentDao.selectById(1);
        assertEquals("Tom", stu.getName());
    }

    @Test
    public void selectAll() {
        List<Student> list = studentDao.selectAll();
        assertEquals(2, list.size());
    }

}