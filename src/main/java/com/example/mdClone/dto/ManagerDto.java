package com.example.mdClone.dto;

import com.example.mdClone.entity.Employee;
import com.example.mdClone.utils.Person;
import lombok.Data;

import java.util.List;

@Data
public class ManagerDto extends Person {

    private List<EmployeeDto> employeeList;
}
