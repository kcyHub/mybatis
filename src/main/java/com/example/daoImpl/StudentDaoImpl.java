package com.example.daoImpl;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final String NAME_SPACE = "com.example.entity.StudentMapper.";

    private static SqlSessionFactory SSF;

    static {
        try {
            InputStream input = Resources.getResourceAsStream("mybatis.xml");
            SSF = new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertStudent(Student stu) {
        SqlSession ss = null;
        try {
            ss = SSF.openSession();
            int result = ss.insert(NAME_SPACE + "insertStudent", stu);
            ss.commit();
            return result;
        } catch (Exception e) {
            if (ss != null) {
                ss.rollback();
            }
            throw e;
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }

    @Override
    public Student selectById(int id) {
        SqlSession ss = null;
        try {
            ss = SSF.openSession();
            return ss.selectOne(NAME_SPACE + "selectById", id);
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }

    @Override
    public List<Student> selectAll() {
        SqlSession ss = null;
        try {
            ss = SSF.openSession();
            return ss.selectList(NAME_SPACE + "selectAll");
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }

    @Override
    public int updateStudent(Student stu) {
        SqlSession ss = null;
        try {
            ss = SSF.openSession();
            int result = ss.update(NAME_SPACE + "updateStudent", stu);
            ss.commit();
            return result;
        } catch (Exception e) {
            if (ss != null) {
                ss.rollback();
            }
            throw e;
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }

    @Override
    public int deleteById(int id) {
        SqlSession ss = null;
        try {
            ss = SSF.openSession();
            int result = ss.delete(NAME_SPACE + "deleteById", id);
            ss.commit();
            return result;
        } catch (Exception e) {
            if (ss != null) {
                ss.rollback();
            }
            throw e;
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }
}
