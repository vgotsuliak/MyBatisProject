package ua.com.gotsuliak.trymybatis.mapper;

import ua.com.gotsuliak.trymybatis.entity.Department;

import java.util.List;


public interface DepartmentMapper {

    Department getDepartment(int id);

    List<Department> getDepartments();

}
