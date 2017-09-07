package com.example.serviceImpl;

import com.example.dao.StudentDao;
import com.example.dao.TeacherDao;
import com.example.entity.Student;
import com.example.entity.Teacher;
import com.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public void insertTeacherAndStudent(Teacher teacher, Student stu) {
        teacherDao.insertTeacher(teacher);
        studentDao.insertStudent(stu);
    }
}
