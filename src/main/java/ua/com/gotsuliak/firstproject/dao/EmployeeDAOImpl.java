package ua.com.gotsuliak.firstproject.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ua.com.gotsuliak.firstproject.entity.Employee;
import ua.com.gotsuliak.firstproject.mapper.EmployeeMapper;

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

}
