package ua.com.gotsuliak.firstproject.dao;

import ua.com.gotsuliak.firstproject.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    Department getDepartment(int id);

    List<Department> getDepartments();

}
