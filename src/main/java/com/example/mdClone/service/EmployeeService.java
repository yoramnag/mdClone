package com.example.mdClone.service;

import com.example.mdClone.dto.EmployeeDto;
import com.example.mdClone.entity.Employee;
import com.example.mdClone.entity.Manager;
import com.example.mdClone.exception.EmployeeAllReadyExistsException;
import com.example.mdClone.exception.EmployeeNotFoundException;
import com.example.mdClone.mapper.EmployeeMapper;
import com.example.mdClone.mapper.ManagerMapper;
import com.example.mdClone.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OrganizationService organizationService;

    /**
     * get all employees
     * @return list for EmployeeDto
     */
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee:employeeList){
            employeeDtoList.add(EmployeeMapper.maoToEmployeeDto(employee,new EmployeeDto()));
        }
        return employeeDtoList;
    }

    /**
     * get employee full name and return it if it found in the database
     * @param firstName employee first name
     * @param lastName employee last name
     * @return employee details
     */
    public EmployeeDto getEmployeeByName(String firstName, String lastName){
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(firstName,lastName);
        if (!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("employee","employee name",firstName+" "+lastName);
        }
        EmployeeDto employeeDto = EmployeeMapper.maoToEmployeeDto(optionalEmployee,new EmployeeDto());
        return employeeDto;
    }

    /**
     * add new employee to the database
     * @param employeeDto employee to save
     */
    public void createEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(employeeDto.getFirstName(),employeeDto.getLastName());
        if(optionalEmployee.isPresent()){
            throw new EmployeeAllReadyExistsException("employee with the name " + employeeDto.getFirstName() + " " + employeeDto.getLastName()
                    +" allready exist in the data base" );
        }
        Employee employee = new Employee();
        EmployeeMapper.mapToEmployee(employeeDto,employee);
        Manager manager = organizationService.retrieveManager(employeeDto.getManager().getFirstName(),employeeDto.getManager().getLastName());
        employee.getManager().setId(manager.getId());
        employeeRepository.save(employee);
    }

    /**
     * update existing employee
     * @param employeeDto updated employee info
     * @param firstName existing employee first name
     * @param lastName existing employee last name
     */
    public void updateEmployee(EmployeeDto employeeDto, String firstName, String lastName){
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(firstName,lastName);
        if (!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("employee","employee name",employeeDto.getFirstName()+" "+employeeDto.getLastName());
        }
        Employee employee = new Employee();
        employee.setId(optionalEmployee.stream().toList().get(0).getId());
        EmployeeMapper.mapToEmployee(employeeDto,employee);
        Manager manager = organizationService.retrieveManager(employeeDto.getManager().getFirstName(),employeeDto.getManager().getLastName());
        employee.getManager().setId(manager.getId());
        employeeRepository.save(employee);
    }

    /**
     * delete existing employee
     * @param firstName existing employee first name
     * @param lastName existing employee last name
     */
    public void deleteEmployeeByName(String firstName, String lastName){
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(firstName,lastName);
        if (!optionalEmployee.isPresent()){
            throw new EmployeeNotFoundException("employee","employee name",firstName+" "+lastName);
        }
        employeeRepository.deleteById(optionalEmployee.stream().toList().get(0).getId());
    }


}
