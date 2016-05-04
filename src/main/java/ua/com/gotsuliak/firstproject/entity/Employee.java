package ua.com.gotsuliak.firstproject.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private int id;
    private String name;
    private Department department;

}
