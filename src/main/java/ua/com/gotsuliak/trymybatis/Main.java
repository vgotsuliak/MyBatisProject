package ua.com.gotsuliak.trymybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ua.com.gotsuliak.trymybatis.dao.DepartmentDAO;
import ua.com.gotsuliak.trymybatis.dao.DepartmentDAOImpl;
import ua.com.gotsuliak.trymybatis.dao.EmployeeDAO;
import ua.com.gotsuliak.trymybatis.dao.EmployeeDAOImpl;
import ua.com.gotsuliak.trymybatis.entity.Department;
import ua.com.gotsuliak.trymybatis.entity.Employee;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

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

            List<Employee> employees = employeeDAO.getEmployees();
            System.out.println("--- All employees ---");
            for (Employee e : employees) {
                System.out.println(e);
            }

            List<Department> departments = departmentDAO.getDepartments();
            System.out.println("--- All departments ---");
            for (Department d : departments) {
                System.out.println(d);
            }

        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

}
