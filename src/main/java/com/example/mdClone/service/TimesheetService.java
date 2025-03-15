package com.example.mdClone.service;

import com.example.mdClone.entity.Employee;
import com.example.mdClone.entity.Timesheet;
import com.example.mdClone.exception.TimesheetNotFoundException;
import com.example.mdClone.repository.TimesheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;
    private final OrganizationService organizationService;

    public List<Timesheet> findAll(){
        return timesheetRepository.findAll();
    }

    public Optional<Timesheet> getTimesheetById(Integer id) {
        Optional<Timesheet> timesheetOptional = timesheetRepository.findById(id);
        if(!timesheetOptional.isPresent()){
            throw new TimesheetNotFoundException("timesheet" , "id" , String.valueOf(id));
        }
        return timesheetOptional;
    }

    public void saveTimesheet(Timesheet timesheet, String firstName, String lastName) {
        Employee employee = organizationService.retrieveEmployee(firstName,lastName);
        timesheet.setEmployee(employee);
        timesheetRepository.save(timesheet);
    }

    public void updateTimesheet(Timesheet timesheet) {
        Optional<Timesheet> timesheetOptional = timesheetRepository.findById(timesheet.getId());
        if(!timesheetOptional.isPresent()){
            throw new TimesheetNotFoundException("timesheet" , "id" , String.valueOf(timesheet.getId()));
        }
        Employee employee = organizationService.retrieveEmployee(timesheet.getEmployee().getFirstName(),timesheet.getEmployee().getLastName());
        timesheet.setEmployee(employee);
        timesheetRepository.save(timesheet);
    }

    public void deleteTimesheetById(Integer id) {
        Optional<Timesheet> timesheetOptional = timesheetRepository.findById(id);
        if(!timesheetOptional.isPresent()){
            throw new TimesheetNotFoundException("timesheet" , "id" , String.valueOf(id));
        }
        timesheetRepository.deleteById(id);
    }
}
