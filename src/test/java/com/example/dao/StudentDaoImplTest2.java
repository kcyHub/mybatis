package com.example.dao;

import com.example.SpringBaseTest;
import com.example.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
public class StudentDaoImplTest2 extends SpringBaseTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    @Commit
    public void insertStudent() {
        assertEquals(1, studentDao.insertStudent(
                new Student("Wang", 19, new Date())));
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void selectById() {
    }

    @Test
    public void selectAll() {
        List<Student> list = studentDao.selectAll();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

}