package com.example.mdClone.mapper;

import com.example.mdClone.dto.EmployeeDto;
import com.example.mdClone.entity.Employee;

import java.util.Optional;

public class EmployeeMapper {
    public static EmployeeDto maoToEmployeeDto(Employee employee, EmployeeDto employeeDto) {
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setRole(employee.getRole());
        employeeDto.setManager(employee.getManager());
        employeeDto.setTimesheetList(employee.getTimesheetList());
        return employeeDto;
    }

    public static EmployeeDto maoToEmployeeDto(Optional<Employee> optionalEmployee, EmployeeDto employeeDto) {
        employeeDto.setFirstName(optionalEmployee.stream().toList().get(0).getFirstName());
        employeeDto.setLastName(optionalEmployee.stream().toList().get(0).getLastName());
        employeeDto.setRole(optionalEmployee.stream().toList().get(0).getRole());
        employeeDto.setManager(optionalEmployee.stream().toList().get(0).getManager());
        employeeDto.setTimesheetList(optionalEmployee.stream().toList().get(0).getTimesheetList());
        return employeeDto;
    }

    public static Employee mapToEmployee(Optional<Employee> optionalEmployee,Employee employee){
        employee.setId(optionalEmployee.stream().toList().get(0).getId());
        employee.setFirstName(optionalEmployee.stream().toList().get(0).getFirstName());
        employee.setLastName(optionalEmployee.stream().toList().get(0).getLastName());
        employee.setRole(optionalEmployee.stream().toList().get(0).getRole());
        employee.setManager(optionalEmployee.stream().toList().get(0).getManager());
        employee.setTimesheetList(optionalEmployee.stream().toList().get(0).getTimesheetList());
        return employee;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto,Employee employee){
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setRole(employeeDto.getRole());
        employee.setManager(employeeDto.getManager());
        employee.setTimesheetList(employeeDto.getTimesheetList());
        return employee;
    }
}
