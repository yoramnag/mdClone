package com.example.mdClone.rest;

import com.example.mdClone.entity.Manager;
import com.example.mdClone.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class ManagerRestController {

    private ManagerService managerService;

    @GetMapping("/getAllManagers")
    public ResponseEntity<List<Manager>> findAllManagers(){
        List<Manager> managerList = managerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(managerList);
    }

    @GetMapping("/getManagerByName")
    public ResponseEntity<Optional<Manager>> getManagerByName(@RequestParam String firstName, @RequestParam String lastName){
        Optional<Manager> optionalManager = managerService.findByName(firstName,lastName);
        return ResponseEntity.status(HttpStatus.OK).body(optionalManager);
    }
}
