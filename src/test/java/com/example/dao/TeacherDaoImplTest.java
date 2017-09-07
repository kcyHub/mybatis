package com.example.dao;

import com.example.SpringBaseTest;
import com.example.entity.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
public class TeacherDaoImplTest extends SpringBaseTest {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    @Commit
    public void insertTeacher() {
        assertEquals(1, teacherDao.insertTeacher(new Teacher("Smith")));
    }

    @Test
    @Commit
    public void batchInsert() {
        List<Teacher> list = Arrays.asList(new Teacher("ArmStrong"), new Teacher("John"), new Teacher("Shara"));
        assertEquals(3, teacherDao.batchInsertTeachers(list));
    }

    @Test
    public void selectAll() {
        List<Teacher> list = teacherDao.selectAll();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

}