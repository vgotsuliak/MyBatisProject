package ua.com.gotsuliak.trymybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ua.com.gotsuliak.trymybatis.entity.Employee;
import ua.com.gotsuliak.trymybatis.mapper.EmployeeMapper;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private SqlSessionFactory sqlSessionFactory;

    public EmployeeDAOImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Employee getEmployee(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            return employeeMapper.getEmployee(id);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            return employeeMapper.getEmployees();
        }
    }

}
