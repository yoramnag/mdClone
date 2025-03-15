package com.example.mdClone.dto;

import com.example.mdClone.entity.Manager;
import com.example.mdClone.entity.Timesheet;
import com.example.mdClone.utils.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto extends Person {

    @NotEmpty(message = "role can NOT be null or empty")
    private String role;
    private List<Timesheet> timesheetList;
    @JsonBackReference
    @NotEmpty(message = "manager can NOT be null or empty")
    private Manager manager;
}
