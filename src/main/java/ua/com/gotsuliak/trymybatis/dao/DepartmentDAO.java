package ua.com.gotsuliak.trymybatis.dao;

import ua.com.gotsuliak.trymybatis.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    Department getDepartment(int id);

    List<Department> getDepartments();

}
