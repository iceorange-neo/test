package org.example.test;

import org.example.dao.IStudentDao;
import org.example.dao.impl.IStudentDaoImpl;
import org.example.domain.Student;
import org.example.service.IStudentService;
import org.example.service.impl.IStudentServiceImpl;
import org.example.utils.ServiceFactory;
import org.example.utils.SqlSessionUtil;

/**
 * @author neo
 * @date 2021/2/18
 * @time 13:34
 */
public class TestMain {
    public static void main(String[] args) {
//        IStudentService proxy = (IStudentService) ServiceFactory.getService(new IStudentDaoImpl());
//        IStudentService service = new IStudentServiceImpl(new IStudentDaoImpl());

//        Student byId = service.getById(1001);
        IStudentDao dao = SqlSessionUtil.getSqlSession().getMapper(IStudentDao.class);
        Student byId = dao.getById(1001);
        System.out.println(byId);
    }
}
