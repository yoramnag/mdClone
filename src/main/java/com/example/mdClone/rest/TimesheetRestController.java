package com.example.mdClone.rest;

import com.example.mdClone.constants.MdCloneConstants;
import com.example.mdClone.dto.ManagerDto;
import com.example.mdClone.dto.ResponseDto;
import com.example.mdClone.entity.Employee;
import com.example.mdClone.entity.Timesheet;
import com.example.mdClone.service.TimesheetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/timesheet" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class TimesheetRestController {

    private TimesheetService timesheetService;

    @GetMapping("/getAllTimesheet")
    public ResponseEntity<List<Timesheet>> findAllManagers(){
        List<Timesheet> timesheetList = timesheetService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(timesheetList);
    }

    @GetMapping("/getTimesheetById")
    public ResponseEntity<Optional<Timesheet>> getTimesheetById(@RequestParam String id){
        Optional<Timesheet> timesheetOptional = timesheetService.getTimesheetById(Integer.valueOf(id));
        return ResponseEntity.status(HttpStatus.OK).body(timesheetOptional);
    }

    public ResponseEntity<ResponseDto> createTimesheet(@RequestBody Timesheet timesheet, @RequestParam String employeeId){
        timesheetService.saveTimesheet(timesheet,Integer.valueOf(employeeId));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MdCloneConstants.STATUS_201,MdCloneConstants.TIMESHEET_MESSAGE_201));
    }
}
