package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.IStudentDao;
import org.example.domain.Student;
import org.example.utils.SqlSessionUtil;

/**
 * @author neo
 * @date 2021/2/18
 * @time 14:32
 */
public class IStudentDaoImpl implements IStudentDao {
    @Override
    public Integer save(Student student) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        return null;
    }

    @Override
    public Student getById(Integer id) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Student s = sqlSession.selectOne("org.example.dao.IStudentDao.getById", id);
        return s;
    }
}
