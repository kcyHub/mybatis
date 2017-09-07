package com.example.daoImpl;

import com.example.dao.TeacherDao;
import com.example.entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private static final String NAME_SPACE = "com.example.entity.TeacherMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertTeacher(Teacher teacher) {
        return sqlSession.insert(NAME_SPACE + "insertTeacher", teacher);
    }

    @Override
    public int batchInsertTeachers(List<Teacher> list) {
        return sqlSession.insert(NAME_SPACE + "batchInsert", list);
    }

    @Override
    public Teacher selectById(int id) {
        return sqlSession.selectOne(NAME_SPACE + "selectById", id);
    }

    @Override
    public List<Teacher> selectAll() {
        return sqlSession.selectList(NAME_SPACE + "selectAll");
    }
}
