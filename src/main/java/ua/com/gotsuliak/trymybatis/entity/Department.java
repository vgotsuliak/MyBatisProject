package ua.com.gotsuliak.trymybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Department {

    private int id;
    private String name;
    private List<Employee> employees;

}
