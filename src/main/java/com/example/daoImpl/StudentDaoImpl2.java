package com.example.daoImpl;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl2 implements StudentDao {

    private static final String NAME_SPACE = "com.example.entity.StudentMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertStudent(Student stu) {
        return sqlSession.insert(NAME_SPACE + "insertStudent", stu);
    }

    @Override
    public int updateStudent(Student stu) {
        return sqlSession.update(NAME_SPACE + "updateStudent", stu);
    }

    @Override
    public int deleteById(int id) {
        return sqlSession.delete(NAME_SPACE + "deleteById", id);
    }

    @Override
    public Student selectById(int id) {
        return sqlSession.selectOne(NAME_SPACE + "selectById", id);
    }

    @Override
    public List<Student> selectAll() {
        return sqlSession.selectList(NAME_SPACE + "selectAll");
    }
}
