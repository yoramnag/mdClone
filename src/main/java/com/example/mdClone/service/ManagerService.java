package com.example.mdClone.service;

import com.example.mdClone.entity.Manager;
import com.example.mdClone.repository.ManagertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {

    private ManagertRepository managertRepository;

    public List<Manager> findAll(){
        return managertRepository.findAll();
    }
    
    public Optional<Manager> findByName(String firstName, String lastName){
        Optional<Manager> optionalManager = managertRepository.findByFirstNameAndLastName(firstName,lastName);
        return optionalManager;
    }
}
