package ua.com.gotsuliak.firstproject.dao;

import ua.com.gotsuliak.firstproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee getEmployee(int id);

    List<Employee> getEmployees();

}
