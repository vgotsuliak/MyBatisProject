package ua.com.gotsuliak.firstproject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ua.com.gotsuliak.firstproject.dao.DepartmentDAO;
import ua.com.gotsuliak.firstproject.dao.DepartmentDAOImpl;
import ua.com.gotsuliak.firstproject.dao.EmployeeDAO;
import ua.com.gotsuliak.firstproject.dao.EmployeeDAOImpl;
import ua.com.gotsuliak.firstproject.entity.Department;
import ua.com.gotsuliak.firstproject.entity.Employee;
import ua.com.gotsuliak.firstproject.mapper.DepartmentMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by VGotsuliak on 14.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            DepartmentDAO departmentDAO = new DepartmentDAOImpl(sqlSessionFactory);
            Department department = departmentDAO.getDepartment(1);
            System.out.println(department);

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(sqlSessionFactory);
            Employee employee = employeeDAO.getEmployee(1);
            System.out.println(employee);


        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

}
