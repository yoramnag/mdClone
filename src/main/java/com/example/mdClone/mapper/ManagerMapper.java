package com.example.mdClone.mapper;

import com.example.mdClone.dto.EmployeeDto;
import com.example.mdClone.dto.ManagerDto;
import com.example.mdClone.entity.Employee;
import com.example.mdClone.entity.Manager;
import com.example.mdClone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerMapper {

    public static ManagerDto mapToManagerDto(Manager manager,ManagerDto managerDto){
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee:manager.getEmployeeList()){
            employeeDtoList.add(EmployeeMapper.maoToEmployeeDto(employee,new EmployeeDto()));
        }
        managerDto.setEmployeeList(employeeDtoList);
        return managerDto;
    }

    public static ManagerDto mapToManagerDto(Optional<Manager> optionalManager, ManagerDto managerDto){
        managerDto.setFirstName(optionalManager.stream().toList().get(0).getFirstName());
        managerDto.setLastName(optionalManager.stream().toList().get(0).getLastName());
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee:optionalManager.stream().toList().get(0).getEmployeeList()){
            employeeDtoList.add(EmployeeMapper.maoToEmployeeDto(employee,new EmployeeDto()));
        }
        managerDto.setEmployeeList(employeeDtoList);
        return managerDto;
    }

    public static Manager mapToManager(Optional<Manager> optionalManager,Manager manager){
        manager.setId(optionalManager.stream().toList().get(0).getId());
        manager.setFirstName(optionalManager.stream().toList().get(0).getFirstName());
        manager.setLastName(optionalManager.stream().toList().get(0).getLastName());
        manager.setEmployeeList(optionalManager.stream().toList().get(0).getEmployeeList());
        return manager;
    }

    public static Manager mapToManager(ManagerDto managerDto,Manager manager){
        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        List<Employee> employeeList = new ArrayList<>();
        manager.setEmployeeList(employeeList);
        return manager;
    }
}
