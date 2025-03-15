package com.example.mdClone.dto;

import com.example.mdClone.entity.Manager;
import com.example.mdClone.entity.Timesheet;
import com.example.mdClone.utils.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto extends Person {

    private String role;
    private List<Timesheet> timesheetList;
    @JsonBackReference
    private Manager manager;
}
