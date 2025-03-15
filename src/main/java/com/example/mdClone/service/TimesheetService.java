package com.example.mdClone.service;

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

    private TimesheetRepository timesheetRepository;

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

    public void saveTimesheet(Timesheet timesheet, Integer employeeId) {
        //Optional<Employee> optionalEmployee =
    }
}
