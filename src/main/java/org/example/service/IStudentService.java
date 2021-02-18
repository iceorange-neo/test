package org.example.service;

import org.example.domain.Student;

/**
 * @author neo
 * @date 2021/2/18
 * @time 14:39
 */
public interface IStudentService {
    Integer save(Student student);
    Student getById(Integer id);
}
