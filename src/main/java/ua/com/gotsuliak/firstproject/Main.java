package ua.com.gotsuliak.firstproject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ua.com.gotsuliak.firstproject.entity.Department;
import ua.com.gotsuliak.firstproject.mapper.DepartmentMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by VGotsuliak on 14.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        DepartmentMapper departmentMapper;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
                Department department = departmentMapper.getDepartment(1);
                System.out.println(department.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
