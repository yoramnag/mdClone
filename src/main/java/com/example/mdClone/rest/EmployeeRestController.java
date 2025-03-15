package com.example.mdClone.rest;

import com.example.mdClone.constants.MdCloneConstants;
import com.example.mdClone.dto.EmployeeDto;
import com.example.mdClone.dto.ManagerDto;
import com.example.mdClone.dto.ResponseDto;
import com.example.mdClone.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employee" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class EmployeeRestController {

    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @GetMapping("/getEmployeeByName")
    public ResponseEntity<EmployeeDto> getEmployeeByName(@RequestParam String firstName, @RequestParam String lastName){
        EmployeeDto employeeDto = employeeService.getEmployeeByName(firstName,lastName);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.createEmployee(employeeDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MdCloneConstants.STATUS_201,MdCloneConstants.EMPLOYEE_MESSAGE_201));
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<ResponseDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam String firstName, @RequestParam String lastName){
        employeeService.updateEmployee(employeeDto,firstName,lastName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(MdCloneConstants.STATUS_200,MdCloneConstants.MESSAGE_200));
    }

    @DeleteMapping("/deleteEmployeeByName")
    public ResponseEntity<ResponseDto> deleteEmployeeByName(@RequestParam String firstName, @RequestParam String lastName){
        employeeService.deleteEmployeeByName(firstName,lastName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(MdCloneConstants.STATUS_200,MdCloneConstants.MESSAGE_200));
    }


}
