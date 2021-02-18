package org.example.dao;

import org.example.domain.Student;

/**
 * @author neo
 * @date 2021/2/18
 * @time 13:44
 */
public interface IStudentDao {
    Integer save(Student student);
    Student getById(Integer id);
}
