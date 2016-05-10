package ua.com.gotsuliak.firstproject.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ua.com.gotsuliak.firstproject.entity.Department;
import ua.com.gotsuliak.firstproject.mapper.DepartmentMapper;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    private SqlSessionFactory sqlSessionFactory;

    public DepartmentDAOImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Department getDepartment(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            return departmentMapper.getDepartment(id);
        }
    }

    @Override
    public List<Department> getDepartments() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            return departmentMapper.getDepartments();
        }
    }
}
