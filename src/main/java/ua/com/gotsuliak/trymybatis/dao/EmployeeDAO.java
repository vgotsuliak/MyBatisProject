package ua.com.gotsuliak.trymybatis.dao;

import ua.com.gotsuliak.trymybatis.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployee(int id);

    List<Employee> getEmployees();

}
