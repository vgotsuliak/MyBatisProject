package ua.com.gotsuliak.firstproject.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ua.com.gotsuliak.firstproject.entity.Department;
import ua.com.gotsuliak.firstproject.entity.Employee;

import java.util.List;


public interface DepartmentMapper {

    /**
     * Annotation @Results is redundant here because property names are the same as column names.
     * Leave it for clearness
     */
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    @Select("Select * from department where id = #{id}")
    Department getDepartment(int id);

    @Select("Select * from department")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "employees", column = "id", many = @Many(select = "getEmployees"))
    })
    List<Department> getDepartments();

    @Select("select * from employee where department_id = #{id}")
    List<Employee> getEmployees(int id);

}
