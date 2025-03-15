package com.example.mdClone.rest;

import com.example.mdClone.constants.MdCloneConstants;
import com.example.mdClone.dto.ManagerDto;
import com.example.mdClone.dto.ResponseDto;
import com.example.mdClone.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/manager" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class ManagerRestController {

    private ManagerService managerService;

    @GetMapping("/getAllManagers")
    public ResponseEntity<List<ManagerDto>> getAllManagers(){
        List<ManagerDto> managerDtoList = managerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(managerDtoList);
    }

    @GetMapping("/getManagerByName")
    public ResponseEntity<ManagerDto> getManagerByName(@RequestParam String firstName, @RequestParam String lastName){
        ManagerDto managerDto = managerService.findByName(firstName,lastName);
        return ResponseEntity.status(HttpStatus.OK).body(managerDto);
    }

    @PostMapping("/createManager")
    public ResponseEntity<ResponseDto> createManager(@RequestBody ManagerDto managerDto){
        managerService.createManager(managerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(MdCloneConstants.STATUS_201,MdCloneConstants.MANAGER_MESSAGE_201));
    }



}
