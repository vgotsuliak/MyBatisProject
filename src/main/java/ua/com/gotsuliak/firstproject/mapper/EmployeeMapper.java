package ua.com.gotsuliak.firstproject.mapper;

import org.apache.ibatis.annotations.Select;
import ua.com.gotsuliak.firstproject.entity.Employee;

public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEmployee(int id);

}
