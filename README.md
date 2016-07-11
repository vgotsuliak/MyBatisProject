# MyBatisProject. 

Example project which shows basics of work with MyBatis framework.

The main point of this tutorial is to describe two ways of describing MyBatis mappers: via XML and via java annotations.

Java Annotations based example (EmployeeMapper):

```java
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
```

XML based example (DepartmentMapper):

```xml
<!DOCTYPE mapper     PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="ua.com.gotsuliak.trymybatis.mapper.DepartmentMapper">
    <resultMap id="department" type="ua.com.gotsuliak.trymybatis.entity.Department">
        <id property="id" column="department_id"/>
        <result property="name" column="department_name"/>
        <collection property="employees" ofType="ua.com.gotsuliak.trymybatis.entity.Employee" column="id"
                    resultMap="employee" columnPrefix="employee_"/>
    </resultMap>
    <resultMap id="employee" type="ua.com.gotsuliak.trymybatis.entity.Employee">
        <id property="id" column="id"/>
        <result property="name" column="name"/>
    </resultMap>
    <select id="getDepartment" parameterType="java.lang.Integer" resultMap="department">
        select
            d.ID as department_id,
            d.NAME as department_name,
            e.ID as employee_id,
            e.NAME as employee_name
        from department d left outer join employee e on d.ID = e.DEPARTMENT_ID
        where d.id = #{id}
    </select>
    <select id="getDepartments" resultMap="department">
        select
            d.ID as department_id,
            d.NAME as department_name,
            e.ID as employee_id,
            e.NAME as employee_name
        from department d left outer join employee e on d.id = e.department_id
    </select>
</mapper>
```