package com.example.dao;

import com.example.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    int insertTeacher(Teacher teacher);

    int batchInsertTeachers(List<Teacher> list);

    Teacher selectById(int id);

    List<Teacher> selectAll();
}
