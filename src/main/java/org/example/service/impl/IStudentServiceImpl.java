package org.example.service.impl;

import org.example.dao.IStudentDao;
import org.example.domain.Student;
import org.example.service.IStudentService;

/**
 * @author neo
 * @date 2021/2/18
 * @time 14:40
 */
public class IStudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;

    public IStudentServiceImpl(IStudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public Integer save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentDao.getById(id);
    }
}
