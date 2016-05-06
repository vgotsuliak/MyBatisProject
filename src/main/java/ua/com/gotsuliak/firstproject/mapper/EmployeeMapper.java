package ua.com.gotsuliak.firstproject.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ua.com.gotsuliak.firstproject.entity.Department;
import ua.com.gotsuliak.firstproject.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "department", column = "id", one = @One(select = "getDepartment"))
    })
    @Select("select * from employee where id=#{id}")
    Employee getEmployee(int id);

    @Select("select * from department where id=#{id}")
    Department getDepartment(int id);

    @Select("select * from employee")
    List<Employee> getEmployees();

}
