package ua.com.gotsuliak.firstproject.entity;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private int departmentFK;

}
