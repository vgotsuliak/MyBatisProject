package ua.com.gotsuliak.firstproject.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ua.com.gotsuliak.firstproject.entity.Department;


public interface DepartmentMapper {

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    @Select("Select name from department where id = #{id}")
    Department getDepartment(int id);

}
