package com.example.mdClone.service;

import com.example.mdClone.dto.ManagerDto;
import com.example.mdClone.entity.Manager;
import com.example.mdClone.exception.ManagerAllReadyExistsException;
import com.example.mdClone.exception.ManagerNotFoundException;
import com.example.mdClone.mapper.ManagerMapper;
import com.example.mdClone.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final OrganizationService organizationService;

    public List<ManagerDto> findAll(){
        List<Manager> managerList = managerRepository.findAll();
        List<ManagerDto> managerDtoList = new ArrayList<>();
        for (Manager manager:managerList){
            managerDtoList.add(ManagerMapper.mapToManagerDto(manager,new ManagerDto()));
        }
        return managerDtoList;
    }
    
    public ManagerDto findByName(String firstName, String lastName){
        Optional<Manager> optionalManager = managerRepository.findByFirstNameAndLastName(firstName,lastName);
        if(!optionalManager.isPresent()){
            throw new ManagerNotFoundException("manager","manger name",firstName+" "+lastName);
        }
        ManagerDto managerDto = new ManagerDto();
        ManagerMapper.mapToManagerDto(optionalManager,managerDto);
        return managerDto;
    }



    public void createManager(ManagerDto managerDto) {
        Optional<Manager> optionalManager = managerRepository.findByFirstNameAndLastName(managerDto.getFirstName(),managerDto.getLastName());
        if(optionalManager.isPresent()){
            throw new ManagerAllReadyExistsException("manager with the name " + managerDto.getFirstName() + " " + managerDto.getLastName()
                    +" allready exist in the data base" );
        }
        Manager manager = new Manager();
        ManagerMapper.mapToManager(managerDto,manager);
        for (int i = 0; i < managerDto.getEmployeeList().size(); i++) {
            manager.getEmployeeList().add(organizationService.retrieveEmployee(managerDto.getEmployeeList().get(i).getFirstName(),
                    managerDto.getEmployeeList().get(i).getLastName()));
        }
        managerRepository.save(manager);
    }


    public void updateManager(ManagerDto managerDto, String firstName, String lastName) {
        Optional<Manager> optionalManager = managerRepository.findByFirstNameAndLastName(firstName,lastName);
        if(!optionalManager.isPresent()){
            throw new ManagerNotFoundException("manager","manger name",firstName+" "+lastName);
        }
        Manager manager = new Manager();
        manager.setId(optionalManager.stream().toList().get(0).getId());
        ManagerMapper.mapToManager(managerDto,manager);
        for (int i = 0; i < managerDto.getEmployeeList().size(); i++) {
            manager.getEmployeeList().add(organizationService.retrieveEmployee(managerDto.getEmployeeList().get(i).getFirstName(),
                    managerDto.getEmployeeList().get(i).getLastName()));
        }
        managerRepository.save(manager);
    }


    public void deleteManagerByName(String firstName, String lastName) {
        Optional<Manager> optionalManager = managerRepository.findByFirstNameAndLastName(firstName,lastName);
        if(!optionalManager.isPresent()){
            throw new ManagerNotFoundException("manager","manger name",firstName+" "+lastName);
        }
        managerRepository.deleteById(optionalManager.stream().toList().get(0).getId());
    }
}
