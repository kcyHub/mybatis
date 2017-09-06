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
    public void testInsertStudent() {
//        Student stu = new Student("Tom", 23, new Date());
//        Student stu = new Student("Bob", 25, new Date());
        Student stu = new Student("Jack", 20, new Date());
        assertEquals(1, studentDao.insertStudent(stu));
    }

    @Test
    public void testSelectById() {
        Student stu = studentDao.selectById(1);
        assertEquals("Tom", stu.getName());
    }

    @Test
    public void testSelectAll() {
        List<Student> list = studentDao.selectAll();
//        assertEquals(2, list.size());
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    @Test
    public void testUpdateStudent() {
        Student stu = new Student();
        stu.setId(3);
        stu.setAge(28);
        assertEquals(1, studentDao.updateStudent(stu));
    }

    @Test
    public void testDeleteById() {
        assertEquals(1, studentDao.deleteById(2));
    }

}